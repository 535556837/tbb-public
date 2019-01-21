package com.zyt.cxfq.service;


import java.util.Map;

import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.model.DQuoteRecord;
import com.zyt.cxfq.model.entity.quoteSeleniumEntity;
import com.zyt.cxfq.plugin.page.BootPage;
import com.zyt.cxfq.util.Result;

public interface PolicyService {
	/**
	 * 新报全价 处理
	 *  利用保单号和车牌号确定保单的唯一性 	加车信息 保单信息，客户信息（身份证号唯一），客户关联员工 ，全报价，投保方案
	 *  
	 * @return
	 */
	public Result addQuote(quoteSeleniumEntity entity);
	/**
	 * 添加报价记录 	
	 * @return
	 */
	public Result addQuoteRecord(DQuoteRecord  record);
	
	/**
	 *  模糊查询 某员工/某车的报价记录		格式：车{投保方案 {时间
	 * @return
	 */
	public Result getQuoteRecordMOHU(BootPage<DQuoteRecord> page,DQuoteRecord  record);
	
	/**
	 *  得到某报价详情内容
	 * @return
	 */
	public Result getQuoteDtlById(String quoteId);
	
	/**
	 *  得到某报价记录内容
	 * @return
	 */
	public Result getQuoteRecordById(String quoteRecordId);
	
}
