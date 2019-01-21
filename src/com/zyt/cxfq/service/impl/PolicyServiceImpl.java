package com.zyt.cxfq.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.iterators.EmptyMapIterator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.zyt.cxfq.common.entity.ExceptionData;
import com.zyt.cxfq.mapper.DCarMapper;
import com.zyt.cxfq.mapper.DCarOwnerMapper;
import com.zyt.cxfq.mapper.DEmployeeMapper;
import com.zyt.cxfq.mapper.DQuoteDtlMapper;
import com.zyt.cxfq.mapper.DQuoteMapper;
import com.zyt.cxfq.mapper.DQuoteRecordMapper;
import com.zyt.cxfq.model.DCar;
import com.zyt.cxfq.model.DCarExample;
import com.zyt.cxfq.model.DCarOwner;
import com.zyt.cxfq.model.DCarOwnerExample;
import com.zyt.cxfq.model.DClient;
import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.model.DEmployeeExample;
import com.zyt.cxfq.model.DQuote;
import com.zyt.cxfq.model.DQuoteDtl;
import com.zyt.cxfq.model.DQuoteRecord;
import com.zyt.cxfq.model.DQuoteRecordExample;
import com.zyt.cxfq.model.entity.quoteSeleniumEntity;
import com.zyt.cxfq.nativedao.CommonDao;
import com.zyt.cxfq.plugin.page.BootPage;
import com.zyt.cxfq.service.EmployeeService;
import com.zyt.cxfq.service.PolicyService;
import com.zyt.cxfq.util.NowTimeStrUtil;
import com.zyt.cxfq.util.Result;
import com.zyt.cxfq.util.ResultCode;
import com.zyt.cxfq.util.sm4.SM4;
import com.zyt.cxfq.util.sm4.SM4Utils;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Component
public class PolicyServiceImpl extends BaseServiceImpl implements PolicyService {

	
	@Autowired
	private DEmployeeMapper EmptyMapper;
	@Autowired
	private CommonDao commonDao;
	@Autowired
	private DCarOwnerMapper dCarOwnerMapper;
	@Autowired
	private DCarMapper dCarMapper;
	@Autowired
	private DQuoteMapper dQuoteMapper;
	
	@Autowired
	private DQuoteDtlMapper DQuoteDtlMapper;
	@Autowired
	private DQuoteRecordMapper dQuoteRecordMapper;
	@Override
	@Transactional
	public Result addQuote(quoteSeleniumEntity entity) {
		// TODO Auto-generated method stub
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		if (StringUtils.isEmpty(entity.getInsuranceBeanJq())||StringUtils.isEmpty(entity.getInsuranceBeanSyList())
				||StringUtils.isEmpty(entity.getInsuranceCar())||StringUtils.isEmpty(entity.getInsurancePerson())
				||StringUtils.isEmpty(entity.getVehicleTaxBean())||StringUtils.isEmpty(entity.getLicenseNo())){
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			resultMap.put("data", entity);
			res.setResultMap(resultMap);
			return res;
		}
		 
		String insuranceBeanJq =entity.getInsuranceBeanJq();				//交强险
		String vehicleTaxBean =entity.getVehicleTaxBean();					//车船税
		String licenseNo =entity.getLicenseNo();							//车牌号
		String syListJson =entity.getInsuranceBeanSyList();					//商业险
		String carJson =entity.getInsuranceCar();							//车信息
		String PersonJson =entity.getInsurancePerson();						//车主信息
		
		//处理 车主
		 DCarOwner owner=JSON.toJavaObject(JSON.parseObject(PersonJson), DCarOwner.class);
		 	//证件号判断是否有此车主
		 if (StringUtils.isNotEmpty(owner.getIdentifyNumber())) {
			 DCarOwnerExample ownerExample = new DCarOwnerExample();
			 ownerExample.createCriteria().andIdentifyNumberEqualTo(owner.getIdentifyNumber());
			 List<DCarOwner> dataOwners = dCarOwnerMapper.selectByExample(ownerExample);
			 if (null==dataOwners||dataOwners.size()==0) {
				 owner.setCreateTime(new Date());
				 dCarOwnerMapper.insert(owner);
			}else {
				owner.setCarOwnersId(dataOwners.get(0).getCarOwnersId());
			}
		 }else{
			 owner.setCreateTime(new Date());
			 dCarOwnerMapper.insert(owner);
		 }
		 //处理 车信息
		 DCar car=JSON.toJavaObject(JSON.parseObject(carJson), DCar.class);
		 car.setCreateTime(new Date());
		 car.setLicenseNo(licenseNo);
		 car.setCarOwnersId(owner.getCarOwnersId());
		 	//是否已有此车
		 DCarExample carExample = new DCarExample();
		 carExample.createCriteria().andLicenseNoEqualTo(licenseNo);
		 List<DCar> dataCars = dCarMapper.selectByExample(carExample);
		 if (null==dataCars||dataCars.size()==0) {
			 dCarMapper.insert(car);
		}else {		//修改拥有人和信息
			car.setCarId(dataCars.get(0).getCarId());
			car.setUpdateUserId(getUserId());
			dCarMapper.updateByPrimaryKeySelective(car);
		}
		 //处理 quote 全价记录
		 DQuote  quo = new DQuote();
		 quo.setCarId(car.getCarId());
		 quo.setCreateTime(new Date());
		 quo.setJqData(insuranceBeanJq);
		 quo.setSyEndDate(entity.getSyEndDate());
		 quo.setSyStartDate(entity.getSyStartDate());
		 quo.setTaxData(vehicleTaxBean);
		 dQuoteMapper.insertSelective(quo);
		 //处理 dtl
			List<DQuoteDtl> quodtlList=  dtlJsonParse(syListJson,quo.getQuoteId());
		 //没有保单信息  无法进行 投保方案 保单记录处理
			for (int i = 0; i < quodtlList.size(); i++) {
				DQuoteDtlMapper.insertSelective(quodtlList.get(i));
			}
			res.setDescription("数据存入成功");
		return res;
	}
	@Override
	public Result addQuoteRecord(DQuoteRecord record) {
		// TODO Auto-generated method stub
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		record.setCreateTime(new Date());
		int temp =dQuoteRecordMapper.insert(record);
		if (temp!=1) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("数据库异常请联系管理员");
			return res;
		}
		resultMap.put("data", record);
		res.setDescription("添加成功!");
    	res.setResultMap(resultMap);
		return res;
	}
	@Override
	public Result getQuoteRecordMOHU(BootPage<DQuoteRecord> page, DQuoteRecord record) {
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		
		DQuoteRecordExample example= new DQuoteRecordExample();
		example.setPage(page);
		example.setOrderByClause(" create_time Desc");
		DQuoteRecordExample.Criteria cri =example.createCriteria();
		if (!StringUtils.isEmpty(record.getEmpId())) {
			cri.andEmpIdEqualTo(record.getEmpId());
		}
		if (!StringUtils.isEmpty(record.getLicenseNo())) {
			cri.andLicenseNoEqualTo(record.getLicenseNo());
		}
		
		List<DQuoteRecord> list =dQuoteRecordMapper.selectByExample(example);
		page.setTotal(dQuoteRecordMapper.countByExample(example));
		page.setRows(list);
		resultMap.put("data",page );
		res.setResultMap(resultMap);
		return res;
	}
	@Override
	public Result getQuoteDtlById(String quoteId) {
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		//校验内容
		if (StringUtils.isEmpty(quoteId)) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			resultMap.put("data", quoteId);
			res.setResultMap(resultMap);
			return res;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sqlid", "selectQuoteById");
		map.put("quoteId", quoteId);
		List<Map<String, Object>> sss = commonDao.GetListData(map);
		resultMap.put("data", sss);
		res.setResultMap(resultMap);
		return res;
	}
	@Override
	public Result getQuoteRecordById(String quoteRecordId) {
		// TODO Auto-generated method stub
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		//校验内容
		if (StringUtils.isEmpty(quoteRecordId)) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			resultMap.put("data", quoteRecordId);
			res.setResultMap(resultMap);
			return res;
		}
		DQuoteRecordExample example = new DQuoteRecordExample();
		DQuoteRecord recode  =  dQuoteRecordMapper.selectByPrimaryKey(quoteRecordId);
		if (null==recode) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("查询数据异常请联系管理员");
			return res;
		}
		resultMap.put("data",recode );
		res.setResultMap(resultMap);
		
		return res;
	}
	
	private List<DQuoteDtl>  dtlJsonParse(String data,String quoId){
		 
		 JSONArray objArr = JSONArray.fromObject(data);
		 List<DQuoteDtl> lis = JSONArray.toList(objArr, new DQuoteDtl(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
//		 DQuoteDtl qdt = (DQuoteDtl) list2.get(0);
		 DQuoteDtl qdt = new DQuoteDtl();
		 for (int i = 0; i < lis.size(); i++) {
			 lis.get(i).setQuoteId(quoId);
				DQuoteDtlMapper.insertSelective(lis.get(i));
			}
		 return lis;
	}
	
	
}
