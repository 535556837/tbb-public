package com.zyt.cxfq.common.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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
public class SqlSourceInterceptor implements Interceptor {

    private Properties properties = new Properties();
	private static final Log logger = LogFactory.getLog(SqlSourceInterceptor.class);
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();

    public SqlSourceInterceptor(){
    	try {
			properties.load(this.getClass().getResourceAsStream("/config/config.properties"));
		} catch (IOException e) {
			properties = null;
			e.printStackTrace();
		}
    }
    //要拦截的接口
    private List<String> interceptorMethod = Arrays.asList(new String[]{
    });
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		// 分离代理对象链,由于目标可能被多个拦截器拦截,从而形成多次代理,通过循环可以分离出最原始的目标类
		//拦截器中的plugin方法中的Plugin.wrap方法每执行一次就会给对象包装上一层代理
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		// 分离最后一个代理对象的目标类
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
		Object parameterObject = metaStatementHandler.getValue("delegate.boundSql.parameterObject");
		String newSql = "";
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
				.getValue("delegate.mappedStatement");
		// 根据ID生成相应类型的sql语句（id需剔除namespace信息）
		String id = mappedStatement.getId();
		id = id.substring(id.lastIndexOf(".") + 1);
		/*if ("insert".equals(id)) {
			newSql = SqlBuilder.buildInsertSql(parameterObject);
		} else if ("update".equals(id)) {
			newSql = SqlBuilder.buildUpdateSql(parameterObject);
		} else if ("delete".equals(id)) {
			newSql = SqlBuilder.buildDeleteSql(parameterObject);
		} else if ("select".equals(id)) {
			newSql = SqlBuilder.buildSelectSql(parameterObject);
		}*/
		logger.debug("Auto generated sql:" + newSql);
		//
		SqlSource sqlSource = buildSqlSource(configuration, newSql, parameterObject.getClass());
		List<ParameterMapping> parameterMappings = sqlSource.getBoundSql(parameterObject).getParameterMappings();
		metaStatementHandler.setValue("delegate.boundSql.sql", sqlSource.getBoundSql(parameterObject).getSql());
		metaStatementHandler.setValue("delegate.boundSql.parameterMappings", parameterMappings);
		// 调用原始statementHandler的prepare方法
		statementHandler = (StatementHandler) metaStatementHandler.getOriginalObject();
		statementHandler.prepare((Connection) invocation.getArgs()[0]);
		// 传递给下一个拦截器处理
		return invocation.proceed();
	}

      
    /** 
     * 拦截器对应的封装原始对象的方法 
     */
    @Override
    public Object plugin(Object arg0) {
		System.out.println("拦截器对应的封装原始对象的方法 "+arg0);
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
	private static SqlSource buildSqlSource(Configuration configuration, String originalSql,
									 Class<?> parameterType) {
		SqlSourceBuilder builder = new SqlSourceBuilder(configuration);
		return builder.parse(originalSql, parameterType, null);
	}



}