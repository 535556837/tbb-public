package com.zyt.cxfq.web;


import com.zyt.cxfq.service.ShortMsgService;
import com.zyt.cxfq.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wyc on 2019/1/11.
 */
@Controller
@RequestMapping(value="Msg")
public class MsgAction  extends BaseAction{
    public static final String DXYZM = "dxyzm";


    @Autowired
    private ShortMsgService sMsgService;


    /**
     *发送短信
     */
    @RequestMapping(value="sendYZM")
    @ResponseBody
    public Result sendYZMSms(String cellPhone) throws  Exception {
        return sMsgService.sendYZMSms(cellPhone);
    }
}
