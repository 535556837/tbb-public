package com.zyt.cxfq.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.iterators.EmptyMapIterator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zyt.cxfq.common.interceptor.CheckLoginInterceptor;
import com.zyt.cxfq.mapper.DEmployeeMapper;
import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.model.DEmployeeExample;
import com.zyt.cxfq.service.EmployeeService;
import com.zyt.cxfq.util.BusinessException;
import com.zyt.cxfq.util.Result;
import com.zyt.cxfq.util.ResultCode;
import com.zyt.cxfq.util.sm4.SM4Utils;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl implements EmployeeService {

	
	@Autowired
	private DEmployeeMapper EmptyMapper;
	
	
	@Override
	public Result login(DEmployee em) {
		// TODO Auto-generated method stub
		Result res = new Result();
		res.setCode(ResultCode.COMMON_SUCCESS);
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		if (StringUtils.isEmpty(em.getuNickName())&&!StringUtils.isEmpty(em.getuPwd())) {
			resultMap.put("data", em);
			res.setResultMap(resultMap);
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("用户名或密码为空");
			return res;
		}
		SM4Utils sm4 = new SM4Utils();
		try {
			sm4.secretKey=SM4Utils.secretKeyWeb;
			String dPwd = sm4.decryptData_ECB(em.getuPwd());
			em.setuPwd(dPwd);
			System.out.println("1---"+dPwd);
			
		} catch (Exception ex) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("非法密码");
			return res;
		}
		DEmployeeExample example =  new DEmployeeExample();
		example.createCriteria().andUNickNameEqualTo(em.getuNickName());
		List<DEmployee> dataList= EmptyMapper.selectByExample(example);
        if (null==dataList||dataList.size()==0) {
        	res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("无此用户");
			return res;
		}
        DEmployee dataEmp = dataList.get(0);
        sm4.secretKey=SM4Utils.secretKeyDB;
        String  daDecodePwd=sm4.decryptData_ECB(dataEmp.getuPwd());
        System.out.println("2--"+daDecodePwd+"--"+em.getuPwd());
        if (dataEmp.getuNickName().equals(em.getuNickName())&& daDecodePwd.equals(em.getuPwd())) {
  //===== 待加入 登陆日志
        	
        	dataEmp.setuPwd(null);
        	resultMap.put("data", dataEmp);
        	res.setResultMap(resultMap);
		}else {
//======= 待加入 错误记录 多次错误锁定			
			res.setDescription("账号或密码错误");
			res.setCode(ResultCode.COMMON_EXCEPTION);
		}
		return res;
	}

	@Override
	public Result save(DEmployee em) {
		// TODO Auto-generated method stub
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		if (StringUtils.isEmpty(em.getuNickName())&&!StringUtils.isEmpty(em.getuPwd())) {
			resultMap.put("data", em);
			res.setResultMap(resultMap);
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("用户名或密码为空");
			return res;
		}
		
		if (StringUtils.isEmpty(em.getuId())) {
			//昵称不可重复
			DEmployeeExample example = new DEmployeeExample();
			example.createCriteria().andUNickNameEqualTo(em.getuNickName());
			List<DEmployee> lis =EmptyMapper.selectByExample(example);
			if (lis.size()!=0) {
				res.setCode(ResultCode.COMMON_EXCEPTION);
				res.setDescription("用户名已经被占用啦，换一个吧");
				return res;
			}
			
			//添加
			if (StringUtils.isEmpty(em.getuPwd())) {
				res.setCode(ResultCode.COMMON_EXCEPTION);
				res.setDescription("未设置密码！");
				return res;
			}
			SM4Utils sm4 = new SM4Utils();
			sm4.secretKey=SM4Utils.secretKeyWeb;
			String pwd  =sm4.decryptData_ECB(em.getuPwd());
			sm4.secretKey=SM4Utils.secretKeyDB;
			String pwdDB  =sm4.encryptData_ECB(pwd);
			em.setuPwd(pwdDB);
			em.setCreateTime(new Date());
			em.setuId(UUID.randomUUID().toString());
			em.setUpdateUserId(getUserId());
			int temp =EmptyMapper.insert(em);
			if (temp!=1) {
				res.setCode(ResultCode.COMMON_EXCEPTION);
				res.setDescription("填加数据异常请联系管理员");
				return res;
			}
			em.setuPwd(null);
        	resultMap.put("data", em);
        	res.setResultMap(resultMap);
		}else {	//修改
			em.setuPwd(null);
			em.setUpdateUserId(getUserId());
			int temp =EmptyMapper.updateByPrimaryKeySelective(em);
			if (temp!=1) {
				res.setCode(ResultCode.COMMON_EXCEPTION);
				res.setDescription("修改数据异常请联系管理员");
				return res;
			}
			em.setuPwd(null);
			resultMap.put("data", em);
        	res.setResultMap(resultMap);
		}
		return res;
	}

	@Override
	public Result remove(String  uId) {
		// TODO Auto-generated method stub
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		if (StringUtils.isEmpty(uId)) {
			resultMap.put("data", uId);
			res.setResultMap(resultMap);
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("参数错误");
			return res;
		}
		int temp =EmptyMapper.deleteByPrimaryKey(uId);
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
	public Result quit(DEmployee em) {
		// TODO Auto-generated method stub
//日志记录
		return null;
	}
	
	/**
     * 设置seession 存入uId ,userCode
     * @param bMember
     * @throws BusinessException
     */
    public void setUserSession(DEmployee emp) throws BusinessException {
        if (!StringUtils.isEmpty(emp.getuId())){
            session.setAttribute(CheckLoginInterceptor.USERID_KEY,emp.getuId());
            session.setAttribute(CheckLoginInterceptor.USER_CODE,emp.getuPhone());
        }else {
            throw new BusinessException("该用户不存在！");
        }
    }
	
}
