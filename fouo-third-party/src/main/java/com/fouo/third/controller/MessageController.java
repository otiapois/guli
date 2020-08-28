package com.fouo.third.controller;

import com.aliyuncs.exceptions.ClientException;
import com.fouo.common.support.R;
import com.fouo.third.utils.SmsUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信验证码控制器
 *
 * @author fouo
 * @date 2020/8/19 14:40
 */
@Controller
@RequestMapping("/third/sms")
public class MessageController {
    @Autowired
    private SmsUtil smsUtil;
    /**
     * 注入短信的模板
     */
    @Value("${aliyun.sms.templateCode}")
    private String templateCode;

    /**
     * 注入短信的签名
     */
    @Value("${aliyun.sms.signName}")
    private String signName;

    /**
     * 发送手机短信验证码
     *
     * @return
     */
    @GetMapping("/sendcode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code) throws ClientException {
        //封装code
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        //将code转成json
        Gson gson = new Gson();
        String json = gson.toJson(map);
        //发送验证码
        smsUtil.sendSms(phone, templateCode, signName, json);
        return R.status(true);
    }
}
