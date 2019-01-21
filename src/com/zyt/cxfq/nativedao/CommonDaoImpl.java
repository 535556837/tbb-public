package com.zyt.cxfq.nativedao;

import com.zyt.cxfq.plugin.page.BootPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.dom4j.DocumentException;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

public class CommonDaoImpl extends SqlSessionDaoSupport implements CommonDao {

	
	@Override
	public List<Map<String, Object>> GetListData(Map map) {
		// TODO Auto-generated method stub
		//数组用逗号分隔传进来，这里遍历map把值改成数组。
		SqlSession sqlSession=this.getSqlSession();
		
		String sqlid=(String) map.get(SQL_ID);
		List<Map<String, Object>> list=sqlSession.selectList("com.zyt.voluntary.Commondao."+sqlid, map);
		return list;
	}
	@Override
	public List<Object> GetListModel(Map map) {
		// TODO Auto-generated method stub
		//数组用逗号分隔传进来，这里遍历map把值改成数组。
		SqlSession sqlSession=this.getSqlSession();
		
		String sqlid=(String) map.get(SQL_ID);
		List<Object> list=sqlSession.selectList("com.zyt.voluntary.Commondao."+sqlid, map);
		return list;
	}

	@Override
	public BootPage<Map<String, Object>> GetPageListData(@Param("page") BootPage<Map<String,Object>> page,@Param("map")Map map) {
		// TODO Auto-generated method stub
		SqlSession sqlSession=this.getSqlSession();
		String sqlid=(String) map.get("sqlid");
		map.put("page", page);

		
		List<Map<String, Object>> list=sqlSession.selectList("com.zyt.voluntary.Commondao."+sqlid, map);
		page.setRows(list);
		return page;
	}

	public BootPage<Map<String, Object>> GetListData3(@Param("page") BootPage<Map<String,Object>> page,@Param("map")Map map) {
		// TODO Auto-generated method stub
		SqlSession sqlSession=this.getSqlSession();
		String sqlid=(String) map.get("sqlid");
		map.put("page", page);

		List<Map<String, Object>> list=sqlSession.selectList("com.zyt.voluntary.Commondao."+sqlid, map);
		page.setRows(list);
		return page;
	}

	

	@Override
	public void Refresh(String classname) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession=this.getSqlSession();
		 String template =  XmlPaser.class.getResource(classname).getFile().substring(1);
		 System.out.println(template);
		RefreshMapper.refresh(sqlSession.getConfiguration(), template);
	}

	@Override
	public void updateSql(String id,String text,String resultType,String XMLname) throws DocumentException {
		// TODO Auto-generated method stub
		XmlPaser.update(id, text,resultType,XMLname);
	}


}
