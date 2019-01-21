package com.zyt.cxfq.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyt.cxfq.mapper.DExceptionRecordMapper;
import com.zyt.cxfq.model.DClient;
import com.zyt.cxfq.model.DExceptionRecord;
import com.zyt.cxfq.model.DExceptionRecordExample;
import com.zyt.cxfq.plugin.page.BootPage;
import com.zyt.cxfq.service.ClientService;
import com.zyt.cxfq.util.Result;



@Controller
@RequestMapping(value="/ClientService")
public class ClientAction extends BaseAction{


	@Autowired
	private ClientService clientService;

	/**
	 * 添加客户信息
	 * @param em
	 * @return
	 */
	@RequestMapping(value="/add")
	@ResponseBody
	public Result add(DClient  client,String carId) {
		return  clientService.add(client,carId);
	}
	/**
	 * 添加客户信息
	 * @param em
	 * @return
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public Result update(DClient  client) {
		return  clientService.update(client);
	}
	/**
	 * remove 客户信息
	 * @param em
	 * @return
	 */
	@RequestMapping(value="/remove")
	@ResponseBody
	public Result remove(String  clientId){
		return  clientService.remove(clientId);
	}
	/**
	 * get 客户信息
	 * @param em
	 * @return
	 */
	@RequestMapping(value="/getById")
	@ResponseBody
	public Result getById(String  clientId){
		return  clientService.getById(clientId);
	}
	/**
	 * get 某员工客户信息
	 * @param em
	 * @return
	 */
	@RequestMapping(value="/getByEmpId")
	@ResponseBody
	public Result getByEmpId(BootPage<DClient> page, String  empId) {
		return  clientService.getByEmpId(page, empId);
	}

}
