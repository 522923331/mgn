package com.tt.controller;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

import java.util.Arrays;

/**
 * @author dangwu
 * @since 2021/3/4 5:32 下午
 */
public class DingDingController {
    //企业钉钉群 1.创建一个群，2.创建一个机器人，完成后获得webHook
    public static void main(String[] args) {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=8c1645c3a94bfa968372eec0111e6c7cb930fae61a3fb66c97a38710f9eb6fbd");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("监控报警:大家晚上好，我是小度~");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList("173****3610"));
// isAtAll类型如果不为Boolean，请升级至最新SDK
        at.setIsAtAll(true);
        request.setAt(at);
        try {
            OapiRobotSendResponse response = client.execute(request);
            System.out.println(JSON.toJSONString(response));
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
