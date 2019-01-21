package com.zyt.cxfq.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyt.cxfq.mapper.DExceptionRecordMapper;
import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.model.DExceptionRecord;
import com.zyt.cxfq.model.DExceptionRecordExample;
import com.zyt.cxfq.model.DQuoteRecord;
import com.zyt.cxfq.model.entity.quoteSeleniumEntity;
import com.zyt.cxfq.plugin.page.BootPage;
import com.zyt.cxfq.service.PolicyService;
import com.zyt.cxfq.util.Result;



@Controller
@RequestMapping(value="/PolicyService")
public class PolicyAction extends BaseAction{

	
	@Autowired
	private PolicyService policyService;
	/**
	 * 新报全价 处理
	 *  利用保单号和车牌号确定保单的唯一性 	加车信息 保单信息，客户信息（身份证号唯一），客户关联员工 ，全报价，投保方案
	 *  
	 * @return
	 */
	@RequestMapping(value="/addQuote")
	@ResponseBody
	public Result addQuote(quoteSeleniumEntity entity) {
		return policyService.addQuote(entity);
	}
	/**
	 * 添加报价记录 	
	 * @return
	 */
	@RequestMapping(value="/addQuoteRecord")
	@ResponseBody
	public Result addQuoteRecord(DQuoteRecord  record) {
		return policyService.addQuoteRecord(record);
	}
	
	/**
	 *  模糊查询 某员工/某车的报价记录		格式：车{投保方案 {时间
	 * @return
	 */
	@RequestMapping(value="/getQuoteRecordMOHU")
	@ResponseBody
	public Result getQuoteRecordMOHU(BootPage<DQuoteRecord> page,DQuoteRecord  record) {
		return policyService.getQuoteRecordMOHU(page,record);
	}
	
	/**
	 *  得到某报价详情内容
	 * @return
	 */
	@RequestMapping(value="/getQuoteDtlById")
	@ResponseBody
	public Result getQuoteDtlById(String quoteId) {
		return policyService.getQuoteDtlById(quoteId);
	}
	
	/**
	 *  得到某报价记录内容
	 * @return
	 */
	@RequestMapping(value="/getQuoteRecordById")
	@ResponseBody
	public Result getQuoteRecordById(String quoteRecordId) {
		return policyService.getQuoteRecordById(quoteRecordId);
	}
}
