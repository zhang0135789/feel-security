package com.feel.common.utils;

import com.alibaba.fastjson.JSON;
import com.feel.common.utils.ChuangLanSmsUtil;

import java.io.UnsupportedEncodingException;

/**
 * @author liaijun
 * @createTime 19/8/27 下午9:50
 * $$LastChangedDate$$
 * $$LastChangedRevision$$
 * $$LastChangedBy$$
 */
public class SendMsg {
    public static final String charset = "utf-8";
    // 用户平台API账号(非登录账号,示例:N1234567)
    public static String account = "N6641776";
    // 用户平台API密码(非登录密码)
    public static String password = "Hfa9AxK02";
    /**
     * 手机发送短信息
     * @param phone
     * @return
     */
    public static String message(String phone,String code) throws UnsupportedEncodingException {
        //请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
        String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
        // 短信内容
        String msg = "【LUD】您好,你的验证码是"+code;

        //状态报告
        String report= "true";

        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        //System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);
        return smsSingleResponse.toString();
    }
}
