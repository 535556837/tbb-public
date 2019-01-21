package com.zyt.cxfq.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyt.cxfq.mapper.DExceptionRecordMapper;
import com.zyt.cxfq.model.DClient;
import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.model.DExceptionRecord;
import com.zyt.cxfq.model.DExceptionRecordExample;
import com.zyt.cxfq.plugin.page.BootPage;
import com.zyt.cxfq.service.EmployeeService;
import com.zyt.cxfq.util.Result;



@Controller
@RequestMapping(value="/empService")
public class EmployeeAction extends BaseAction{


	@Autowired
	private EmployeeService employeeService;


	@RequestMapping(value="/login")
	@ResponseBody
	public Result login(DEmployee  em) {
		 
		return employeeService.login(em);
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public Result save(DEmployee  em) {
		 
		return employeeService.save(em);
	}
	
	@RequestMapping(value="/remove")
	@ResponseBody
	public Result remove(String  uId) {
		 
		return employeeService.remove(uId);
	}
	@RequestMapping(value="/quit")
	@ResponseBody
	public Result quit(DEmployee  em) {
		 
		return employeeService.quit(em);
	}
	
	
}
