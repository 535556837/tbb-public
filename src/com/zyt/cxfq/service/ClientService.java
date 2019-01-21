package com.zyt.cxfq.service;


import com.zyt.cxfq.model.DClient;
import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.plugin.page.BootPage;
import com.zyt.cxfq.util.Result;

public interface ClientService {
	
	/**
	 * 添加 修改客户信息
	 * @param em
	 * @return
	 */
	public Result add(DClient  client,String carId) ;
	
	/**
	 * 添加 修改客户信息
	 * @param em
	 * @return
	 */
	public Result update(DClient  client) ;
	/**
	 * remove 客户信息
	 * @param em
	 * @return
	 */
	public Result remove(String  clientId);
	
	/**
	 * get 客户信息
	 * @param em
	 * @return
	 */
	public Result getById(String  clientId) ;
	
	
	/**
	 * get 某员工客户信息
	 * @param em
	 * @return
	 */
	public Result getByEmpId(BootPage<DClient> page, String  empId) ;
}
