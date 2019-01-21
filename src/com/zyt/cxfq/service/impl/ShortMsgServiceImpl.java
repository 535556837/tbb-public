package com.zyt.cxfq.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zyt.cxfq.common.util.BooSms;
import com.zyt.cxfq.mapper.DShortMsgMapper;
import com.zyt.cxfq.model.DShortMsg;
import com.zyt.cxfq.service.ShortMsgService;
import com.zyt.cxfq.util.BusinessException;
import com.zyt.cxfq.util.Result;
import com.zyt.cxfq.util.ResultCode;

import net.sf.json.JSONObject;
@Component
public class ShortMsgServiceImpl  implements ShortMsgService{
	
    @Autowired
    private DShortMsgMapper dMsgMapper;
	
	@Override
	public Result sendYZMSms(String cellPhone) throws Exception {
		// TODO Auto-generated method stub
		Result res = new Result();
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		res.setCode(ResultCode.COMMON_SUCCESS);
		if (StringUtils.isEmpty(cellPhone) || cellPhone.length() != 11) {
			res.setCode(ResultCode.COMMON_EXCEPTION);
			res.setDescription("手机号错误!");
			return res;
        }

        String code = getRandom();
        String result=null;
        try {
			 result =BooSms.post(cellPhone, code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       /* //调用接口发短信
        BooSms.post(cellPhone, code);*/

        DShortMsg tMessagemanager = new DShortMsg();
        tMessagemanager.setTitle(cellPhone);
        tMessagemanager.setContent(code);
        //消息类型（2短信验证码）
        tMessagemanager.setMsgtype(2);
        if (result != null) {
            JSONObject jsonObject = JSONObject.fromObject(result);
            if ("0".equals(jsonObject.getString("code"))) {
                tMessagemanager.setSendtype("发送成功, "+ result.toString());
            } else {
                tMessagemanager.setSendtype("发送失败, " + result.toString());
            }
        } else {
            tMessagemanager.setSendtype("发送失败,响应内容为null");
        }
        
        int resint =dMsgMapper.insertSelective(tMessagemanager);
        if (resint==1) {
        	resultMap.put("data", tMessagemanager);
        	res.setResultMap(resultMap);
		}else {
			res.setDescription("数据写入失败");
			res.setCode(ResultCode.COMMON_EXCEPTION);
		}
      return res;
	}
	
	
	   public static String getRandom() {
	        Random random = new Random();
	        String result = "";
	        for(int i =0;i<6;i++) {
	            result += random.nextInt(10);
	        }
	        return result;
	    }
}
