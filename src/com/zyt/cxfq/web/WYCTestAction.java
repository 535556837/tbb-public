package com.zyt.cxfq.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyt.cxfq.common.util.ConfigManager;
import com.zyt.cxfq.mapper.DQuoteDtlMapper;
import com.zyt.cxfq.model.DCar;
import com.zyt.cxfq.model.DCarOwner;
import com.zyt.cxfq.model.DQuote;
import com.zyt.cxfq.model.DQuoteDtl;
import com.zyt.cxfq.model.DQuoteRecord;
import com.zyt.cxfq.model.entity.quoteSeleniumEntity;
import com.zyt.cxfq.nativedao.CommonDao;
import com.zyt.cxfq.util.Result;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tpc on 2017/8/17.
 */
@Controller
@RequestMapping("/t")
public class WYCTestAction extends BaseAction {

	@Autowired
    protected CommonDao commonDao;
	@Autowired
	private DQuoteDtlMapper DQuoteDtlMapper;
	
    /**
     *测试生成文件给公安查结果
     */
    @ResponseBody
    @RequestMapping("/tparse")
    public Object testCreat(quoteSeleniumEntity entity)throws Exception{
    	System.out.println(entity.getInsuranceBeanSyList());
    	JSONArray objArr = JSONArray.fromObject(entity.getInsuranceBeanSyList());
		 
		 List<DQuoteDtl> list2 = JSONArray.toList(objArr, new DQuoteDtl(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
		for (int i = 0; i < list2.size(); i++) {
			list2.get(i).setQuoteId("qttt");
			DQuoteDtlMapper.insertSelective(list2.get(i));
		}
		 
    	return  "yes";
    }
    @ResponseBody
    @RequestMapping("/car")
    public Object car(quoteSeleniumEntity entity)throws Exception{
    	System.err.println(entity.getInsuranceCar());
    	JSONObject s = JSON.parseObject(entity.getInsuranceCar());
    	DCar car=JSON.toJavaObject(JSON.parseObject(entity.getInsuranceCar()), DCar.class);
    	System.out.println(car);
    	return  car;
    }
    @ResponseBody
    @RequestMapping("/person")
    public Object person(quoteSeleniumEntity entity)throws Exception{
    	System.err.println(entity.getInsurancePerson());
    	JSONObject s = JSON.parseObject(entity.getInsuranceCar());
    	DCarOwner owner=JSON.toJavaObject(JSON.parseObject(entity.getInsuranceCar()), DCarOwner.class);
    	System.out.println(owner);
    	return  owner;
    }
    		
    @ResponseBody
    @RequestMapping("/t")
    public String getii() {
    	return "OK";
    	
    }
}
