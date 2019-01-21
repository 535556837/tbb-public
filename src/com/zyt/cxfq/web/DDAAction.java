package com.zyt.cxfq.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyt.cxfq.mapper.DExceptionRecordMapper;
import com.zyt.cxfq.model.DExceptionRecord;
import com.zyt.cxfq.model.DExceptionRecordExample;
import com.zyt.cxfq.plugin.page.BootPage;



@Controller
@RequestMapping(value="/dda")
public class DDAAction extends BaseAction{


	@Autowired
	private DExceptionRecordMapper dDAMapper;


	@RequestMapping(value="/list")
	@ResponseBody
	public List<DExceptionRecord> roleInfo(BootPage<DExceptionRecord> reBootPage) {
		DExceptionRecordExample ex = new DExceptionRecordExample();
		ex.setPage(reBootPage);
		 
		return dDAMapper.selectByExample(ex);
	}
	

}
