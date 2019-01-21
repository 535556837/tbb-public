package com.zyt.cxfq.service;


import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.util.Result;

public interface EmployeeService {
	
	/**
	 * 登陆验证
	 * @param em
	 * @return
	 */
	public Result login(DEmployee  em);
	
	/**
	 * 添加 修改员工账号信息
	 * @param em
	 * @return
	 */
	public Result save(DEmployee  em) ;
	/**
	 * 移除 员工账号
	 * @param em
	 * @return
	 */
	public Result remove(String  uId);
	
	/**
	 * 账号退出
	 * @param em
	 * @return
	 */
	public Result quit(DEmployee  em) ;
}
