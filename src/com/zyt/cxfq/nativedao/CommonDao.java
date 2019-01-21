package com.zyt.cxfq.nativedao;

import com.zyt.cxfq.plugin.page.BootPage;
import org.apache.ibatis.annotations.Param;
import org.dom4j.DocumentException;

import java.util.List;
import java.util.Map;

public interface CommonDao {

	 String SQL_ID = "sqlid";
	 

	 List<Map<String,Object>> GetListData(Map map);
	 void Refresh(String classname) throws Exception;
	 void updateSql(String id,String text,String resultType,String XMLname) throws DocumentException;
	 BootPage<Map<String,Object>> GetPageListData(@Param("page") BootPage<Map<String,Object>> page,@Param("map")Map map);
	 List<Object> GetListModel(Map map);

}
