package com.zyt.cxfq.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.iterators.EmptyMapIterator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zyt.cxfq.mapper.DCarMapper;
import com.zyt.cxfq.mapper.DClientMapper;
import com.zyt.cxfq.mapper.DEmpClientMapper;
import com.zyt.cxfq.mapper.DEmployeeMapper;
import com.zyt.cxfq.model.DCar;
import com.zyt.cxfq.model.DClient;
import com.zyt.cxfq.model.DClientExample;
import com.zyt.cxfq.model.DEmpClient;
import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.model.DEmployeeExample;
import com.zyt.cxfq.model.DQuoteRecord;
import com.zyt.cxfq.nativedao.CommonDao;
import com.zyt.cxfq.plugin.page.BootPage;
import com.zyt.cxfq.service.ClientService;
import com.zyt.cxfq.service.EmployeeService;
import com.zyt.cxfq.util.Result;
import com.zyt.cxfq.util.ResultCode;
import com.zyt.cxfq.util.sm4.SM4;
import com.zyt.cxfq.util.sm4.SM4Utils;

@Component
public class ClientServiceImpl extends BaseServiceImpl implements ClientService {

	
	@Autowired
	private DClientMapper dClientMapper;
	@Autowired
	private DEmpClientMapper dEmpClientMapper;
	@Autowired
	private DCarMapper dCarMapper;
	@Autowired
	private CommonDao commonDao;
	
	
	@Override
	public Result update(DClient client) {
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		//校验内容
		if (StringUtils.isEmpty(client.getName())||StringUtils.isEmpty(client.getPhone())||StringUtils.isEmpty(client.getClientId())) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			resultMap.put("data", client);
	    	res.setResultMap(resultMap);
			return res;
		}
		dClientMapper.updateByPrimaryKeySelective(client);
		resultMap.put("data", client);
		res.setResultMap(resultMap);
		res.setDescription("修改成功");
		return res;
	}
	@Override
	public Result add(DClient client,String carId) {
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		//校验内容
		if (StringUtils.isEmpty(client.getName())||StringUtils.isEmpty(client.getPhone())||StringUtils.isEmpty(carId)) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			resultMap.put("data", client);
			resultMap.put("carId", carId);
	    	res.setResultMap(resultMap);
			return res;
		}
		
		DClientExample ex=new DClientExample();
		ex.createCriteria().andPhoneEqualTo(client.getPhone());
		List<DClient> lis = dClientMapper.selectByExample(ex);
		if (null!=lis&&lis.size()!=0) {
			res.setDescription("此电话的用户已存在");
			client =lis.get(0);
		}else {
			client.setCreateTime(new Date());
			int temp =dClientMapper.insertSelective(client);
			
			if (temp!=1) {
				res.setCode(ResultCode.COMMON_EXCEPTION);
				res.setDescription("添加数据异常请联系管理员");
				return res;
			}
			DEmpClient dEmpClient = new DEmpClient();
			dEmpClient.setClientId(client.getClientId());
			dEmpClient.setuId(getUserId());
			dEmpClient.setCreateTime(new Date());
			dEmpClientMapper.insert(dEmpClient);
		}
		DCar car = new DCar();
		car.setCarId(carId);
		car.setClientId(client.getClientId());
		dCarMapper.updateByPrimaryKeySelective(car);
		resultMap.put("data", client);
		res.setDescription("操作成功!");
    	res.setResultMap(resultMap);
		return res;
	}

	@Override
	public Result remove(String clientId) {
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		//校验内容
		if (StringUtils.isEmpty(clientId)) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			resultMap.put("data", clientId);
			res.setResultMap(resultMap);
			return res;
		}
				
		int temp =dClientMapper.deleteByPrimaryKey(clientId);
		if (temp!=1) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("修改数据异常请联系管理员");
			return res;
		}
		resultMap.put("data", null);
		res.setDescription("删除成功!");
    	res.setResultMap(resultMap);
		return res;
	}

	@Override
	public Result getById(String clientId) {
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		//校验内容
		if (StringUtils.isEmpty(clientId)) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			resultMap.put("data", clientId);
			res.setResultMap(resultMap);
			return res;
		}
		DClient temp =dClientMapper.selectByPrimaryKey(clientId);
		if (null==temp) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("查询数据异常请联系管理员");
			return res;
		}
		resultMap.put("data", temp);
		res.setDescription("查询成功");
    	res.setResultMap(resultMap);
		return res;
	}

	@Override
	public Result getByEmpId(BootPage<DClient> page, String empId) {
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		//校验内容
		if (StringUtils.isEmpty(empId)) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			resultMap.put("data", empId);
			res.setResultMap(resultMap);
			return res;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sqlid", "selectClientByEmpId");
		map.put("empId", empId);
		map.put("page", page);
		List<Map<String, Object>> sss = commonDao.GetListData(map);
		 List<DClient> list  = new ArrayList<DClient>();
		 for (Map<String, Object> map2 : sss) {
			list.add( JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(map2)), DClient.class));
		} 
		page.setRows(list);
		
		resultMap.put("data", page);
		res.setDescription("查询成功!");
    	res.setResultMap(resultMap);
		return res;
	}
	
}
