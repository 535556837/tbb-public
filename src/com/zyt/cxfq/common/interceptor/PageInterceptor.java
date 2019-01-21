package com.zyt.cxfq.common.interceptor;

import com.zyt.cxfq.common.util.ReflectHelper;
import com.zyt.cxfq.plugin.page.BootPage;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SubSelect;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * 
 * 分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。 
 * 利用拦截器实现Mybatis分页的原理： 
 * 要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象，Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象，而且对应的Sql语句 
 * 是在Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement的Sql语句下手。在Mybatis中Statement语句是通过RoutingStatementHandler对象的 
 * prepare方法生成的。所以利用拦截器实现Mybatis分页的一个思路就是拦截StatementHandler接口的prepare方法，然后在拦截器方法中把Sql语句改成对应的分页查询Sql语句，之后再调用 
 * StatementHandler对象的prepare方法，即调用invocation.proceed()。 
 * 对于分页而言，在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少，这是通过获取到了原始的Sql语句后，把它改为对应的统计语句再利用Mybatis封装好的参数和设 
 * 置参数的功能把Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计。 
 * 
 */  
@Service
@Intercepts({
		@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})
})
public class PageInterceptor implements Interceptor {
	private String dialect = "mysql"; //数据库方言  
    private String pageSqlId = ""; //mapper.xml中需要拦截的ID(正则匹配)  
    
    private Properties properties = new Properties();
    
    public PageInterceptor(){
    	try {
			properties.load(this.getClass().getResourceAsStream("/config/config.properties"));
		} catch (IOException e) {
			properties = null;
			e.printStackTrace();
		}
    }
    @Autowired
    private HttpSession session;
    //排除在外的sql
    private List<String> excludeMethod = Arrays.asList(new String[]{
    		"com.zyt.cxfq.dao.TProductinfoDao.selectTProductList",
			"com.zyt.cxfq.dao.ShareManDao.getShare",
			"com.zyt.cxfq.dao.UserSignDao.userSign",
			"com.zyt.cxfq.dao.ShareManDao.getMyShare"
    });
    //添加了systemid的表
    private List<String> hasSystemidTable = Arrays.asList(new String[]{
			"test"
    });
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
    	//对于StatementHandler其实只有两个实现类，一个是RoutingStatementHandler，另一个是抽象类BaseStatementHandler，  
        //BaseStatementHandler有三个子类，分别是SimpleStatementHandler，PreparedStatementHandler和CallableStatementHandler，  
        //SimpleStatementHandler是用于处理Statement的，PreparedStatementHandler是处理PreparedStatement的，而CallableStatementHandler是  
        //处理CallableStatement的。Mybatis在进行Sql语句处理的时候都是建立的RoutingStatementHandler，而在RoutingStatementHandler里面拥有一个  
        //StatementHandler类型的delegate属性，RoutingStatementHandler会依据Statement的不同建立对应的BaseStatementHandler，即SimpleStatementHandler、  
        //PreparedStatementHandler或CallableStatementHandler，在RoutingStatementHandler里面所有StatementHandler接口方法的实现都是调用的delegate对应的方法。  
        //我们在PageInterceptor类上已经用@Signature标记了该Interceptor只拦截StatementHandler接口的prepare方法，又因为Mybatis只有在建立RoutingStatementHandler的时候  
        //是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。
          
    	String systemid = "";
    	String userid = "";
    	Boolean isinterceptor = false; 
		if(session!=null){
			if(properties != null){
				isinterceptor = Boolean.parseBoolean(properties.getProperty("isinterceptorsql","false"));
			}
//			userid = session.getAttribute("userid") == null ? "" : session.getAttribute("userid").toString();
//			systemid = session.getAttribute("loginsystemid") == null ? "" : session.getAttribute("loginsystemid").toString();
//			System.out.println("PageInterceptor,当前登录用户的userId:"+userid);
//			System.out.println("PageInterceptor,当前登录用户的systemid:"+systemid);
		}
    	
		if(invocation.getTarget() instanceof RoutingStatementHandler){  
			RoutingStatementHandler statementHandler = (RoutingStatementHandler)invocation.getTarget();  
			StatementHandler delegate = (StatementHandler) ReflectHelper.getFieldValue(statementHandler, "delegate");  
			BoundSql boundSql = delegate.getBoundSql();
			//通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
			MappedStatement mapped = (MappedStatement)ReflectHelper.getFieldValue(delegate, "mappedStatement");
			//拦截到的prepare方法参数是一个Connection对象  
            Connection connection = (Connection)invocation.getArgs()[0];
            //获取请求参数
    		Object obj = boundSql.getParameterObject();
			//Object params = statementHandler.getParameterHandler().getParameterObject();
			//System.out.println("left join出现的次数："+appearNumber(boundSql.getSql(),"left join"));
			
			//System.out.println("where出现的次数："+appearNumber(boundSql.getSql(),"where"));
			
			
			
			//添加字段处理
			//当前请求的mapper方法
			String sqlMethod = mapped.getId();
			System.out.println("当前请求sql方法:   "+sqlMethod);

			if(isinterceptor && !excludeMethod.contains(sqlMethod)){
				//处理sql
				String sql = boundSql.getSql();
//				System.out.println("拦截器拦截到的sql:\n"+sql);

				//Jsqlparser !"1".equals(userid) &&
//				CCJSqlParserManager pm = new CCJSqlParserManager();
				String finalSql = "";
				try {
//					Statement statement = pm.parse(new StringReader(sql));
//					Map<String,Object> addParams = new HashMap<String,Object>();
//					addParams.put("systemid", systemid);
					//调用拦截处理方法,20171213处理只做分页,不解析sql
//					finalSql = preBuildSql(statement,obj,mapped,connection,addParams);
					finalSql = selectAddPage(obj,sql,mapped,connection);
				} catch (Exception e) {
					System.out.println("sql处理异常,不在做分页处理");
					finalSql = sql;
				}

//				System.out.println("PageInterceptor修改之后的sql为:"+finalSql);
				if(!"".equals(finalSql)){
					ReflectHelper.setFieldValue(boundSql, "sql", finalSql);
				}
				
			}
    	}
    	return invocation.proceed();  
	}
    /**
     * 根据sql类型不同分别处理
     * @param statement
     * @param obj
     * @param mapped
     * @param connection
     * @return
     * @throws SQLException
     */
    public String preBuildSql(Statement statement,Object obj,MappedStatement mapped,Connection connection,Map<String,Object> addParams) throws SQLException{
    	String resultSql = "";
    	if (statement instanceof Select) {
			
			Select selectStatement = (Select) statement;
			PlainSelect select = (PlainSelect) selectStatement.getSelectBody();
			//添加where systemid = 'systemid'
			selectAddWhere(select,"systemid",addParams.get("systemid").toString());
			//添加分页条件
			resultSql = selectAddPage(obj,statement.toString(),mapped,connection);
		}else if(statement instanceof Insert){
			Insert insertStatement = (Insert) statement;
			//添加systemid字段内容
			if(hasSystemidTable.contains(insertStatement.getTable().getName())){
				insertStatement.getColumns().add(new Column("systemid"));
				ExpressionList itemList = (ExpressionList)insertStatement.getItemsList();
				itemList.getExpressions().add(new StringValue(addParams.get("systemid").toString()));
			}
			resultSql = statement.toString();
		}
    	return resultSql;
    }
    /**
     * 增加分页参数
     * @param obj
     * @param sql
     * @param mapped
     * @param connection
     * @return
     * @throws SQLException
     */
    public String selectAddPage(Object obj,String sql,MappedStatement mapped,Connection connection) throws SQLException{
    	
		BootPage<?> page = null;
        if (obj instanceof HashMap) { 
        	Set<Entry<String,Object>> se=((HashMap) obj).entrySet();
            for (Entry entry : se) {                	
            	if(entry.getValue() instanceof BootPage<?>){
            		page = (BootPage<?>)entry.getValue();
            		System.out.println("收到有分页参数了:"+page);
            	}
            }
            if(page != null){
                //给当前的page参数对象设置总记录数  
                this.setTotalRecord(obj,page,mapped, connection,sql);  
                //获取分页Sql语句  
                String pageSql = this.getPageSql(page, sql);  
                return pageSql;
            }
        }
        return sql;
    }
    /**
     * 解析增加where条件
     * @param select
     */
    public void selectAddWhere(PlainSelect select,String column,String param){
		List<String> tableAlias = new ArrayList<String>();
		if(select.getFromItem() instanceof Table){
			Table table = (Table) select.getFromItem();
			if(hasSystemidTable.contains(table.getName().toLowerCase())){
				if(table.getAlias() != null){
					tableAlias.add(table.getAlias().getName());
				}else{
					tableAlias.add(table.getName());
				}
			}
		}
		List<Join> joins = select.getJoins();
		if(joins != null && joins.size() > 0){
			for(Join join : joins){
				if(join.getRightItem() instanceof Table){
					Table table = (Table) join.getRightItem();
					if(hasSystemidTable.contains(table.getName().toLowerCase())){
						if(table.getAlias() != null){
							tableAlias.add(table.getAlias().getName());
						}else{
							tableAlias.add(table.getName());
						}
					}
				}else 
					if(join.getRightItem() != null && join.getRightItem() instanceof SubSelect){
						SubSelect subSelect = (SubSelect) join.getRightItem();
						selectAddWhere((PlainSelect)subSelect.getSelectBody(),column,param);
					}
			}
		}
		String where = "";
		for(String alias : tableAlias){
			where += " and "+alias+"."+column+"= '"+param+"'";
		}
		if(!"".equals(where)){
			Expression where_expression = null;
			try {
				if(select.getWhere() != null){
					where_expression = (Expression) (CCJSqlParserUtil.parseCondExpression(select.getWhere()+where)); 
				}else{
					where_expression = (Expression) (CCJSqlParserUtil.parseCondExpression(where.replaceFirst("and", ""))); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			select.setWhere(where_expression);
		}
	}
    
    /**
     * 获取指定字符串出现的次数
     * 
     * @param srcText 源字符串
     * @param findText 要查找的字符串
     * @return
     */
    private  int appearNumber(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }
    /** 
     * 给当前的参数对象page设置总记录数 
     * 
     * @param page Mapper映射语句对应的参数对象 
     * @param mappedStatement Mapper映射语句 
     * @param connection 当前的数据库连接 
     */  
    private void setTotalRecord(Object paramObj, BootPage<?> page, MappedStatement mappedStatement, Connection connection, String sql) throws SQLException{
       //获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。  
       //delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。  
       BoundSql boundSql = mappedStatement.getBoundSql(paramObj);  
       //获取到我们自己写在Mapper映射语句中对应的Sql语句  
       //String sql = boundSql.getSql();  
       //通过查询Sql语句获取到对应的计算总记录数的sql语句  
       String countSql = this.getCountSql(sql);  
       //通过BoundSql获取对应的参数映射  
       List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();  
       //利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。  
       BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, paramObj);  
       //通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象  
       ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, paramObj, countBoundSql);  
       //通过connection建立一个countSql对应的PreparedStatement对象。  
       PreparedStatement pstmt = null;  
       ResultSet rs = null;  
       pstmt = connection.prepareStatement(countSql);  
       //通过parameterHandler给PreparedStatement对象设置参数  
       parameterHandler.setParameters(pstmt);  
       //之后就是执行获取总记录数的Sql语句和获取结果了。  
       rs = pstmt.executeQuery();  
       if (rs.next()) {  
          int totalRecord = rs.getInt(1);  
          //给当前的参数page对象设置总记录数  
          page.setTotal(totalRecord);
       }  
       if (rs != null) {rs.close();}  
       if (pstmt != null) {pstmt.close(); } 
    }  
    
    /** 
     * 根据原Sql语句获取对应的查询总记录数的Sql语句 
     * @param sql 
     * @return 
     */  
    private String getCountSql(String sql) {  
    	//因为是jsqlparser处理过的语句所以from必然是大写
//    	int index = sql.indexOf("FROM");
    	return "SELECT count(*) from (" + sql+") a";
    }  
    
    /** 
     * 根据page对象获取对应的分页查询Sql语句，这里只做了两种数据库类型，Mysql和Oracle 
     * 其它的数据库都 没有进行分页 
     * 
     * @param page 分页对象 
     * @param sql 原sql语句 
     * @return 
     */  
    private String getPageSql(BootPage<?> page, String sql) {  
       StringBuffer sqlBuffer = new StringBuffer(sql);  
       if ("mysql".equalsIgnoreCase(dialect)) {  
           return getMysqlPageSql(page, sqlBuffer);  
       } else if ("oracle".equalsIgnoreCase(dialect)) {  
           return getOraclePageSql(page, sqlBuffer);  
       }  
       return sqlBuffer.toString();  
    }  
    
    /** 
    * 获取Mysql数据库的分页查询语句 
    * @param page 分页对象 
    * @param sqlBuffer 包含原sql语句的StringBuffer对象 
    * @return Mysql数据库分页语句 
    */
	private String getMysqlPageSql(BootPage<?> page, StringBuffer sqlBuffer) {
		//计算第一条记录的位置，Mysql中记录的位置是从0开始的。
//	   System.out.println("page:"+page.getPage()+"-------"+page.getRows());
//      int offset = (page.getPage() - 1) * page.getRows();  
		int offset = page.getOffset();
		sqlBuffer.append(" limit ").append(offset).append(",").append(page.getLimit());
		return sqlBuffer.toString();
	}
    
   /** 
    * 获取Oracle数据库的分页查询语句 
    * @param page 分页对象 
    * @param sqlBuffer 包含原sql语句的StringBuffer对象 
    * @return Oracle数据库的分页查询语句 
    */  
   private String getOraclePageSql(BootPage<?> page, StringBuffer sqlBuffer) {  
      //计算第一条记录的位置，Oracle分页是通过rownum进行的，而rownum是从1开始的  
//      int offset = (page.getPage() - 1) * page.getRows() + 1;  
      int offset = page.getOffset();  
      sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(offset + page.getLimit());  
      sqlBuffer.insert(0, "select * from (").append(") where r >= ").append(offset);  
      //上面的Sql语句拼接之后大概是这个样子：  
      //select * from (select u.*, rownum r from (select * from t_user) u where rownum < 31) where r >= 16  
      return sqlBuffer.toString();  
   }  
   
      
    /** 
     * 拦截器对应的封装原始对象的方法 
     */   
   @Override
    public Object plugin(Object arg0) {
		// TODO Auto-generated method stub
    	if (arg0 instanceof StatementHandler) {  
            return Plugin.wrap(arg0, this);  
        } else {  
            return arg0;  
        } 
    }  
  
    /** 
     * 设置注册拦截器时设定的属性 
     */
   @Override
    public void setProperties(Properties p) {
    	
    }

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String getPageSqlId() {
		return pageSqlId;
	}

	public void setPageSqlId(String pageSqlId) {
		this.pageSqlId = pageSqlId;
	}
    
}