package com.tt.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.client.identify.Base64;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 签名dingTalk实例
 * @author dangwu
 * @since 2021/3/8 8:06 下午
 */
@Slf4j
public class DingTalkUtil {

    public DingTalkUtil() {

    }

    public static void sendMsg() {
        String secret = "SEC0015c1ab2fa654ea7bdcad311c029c499ab1d360d23aab37b2a89f70639fb008";
        Long timestamp = System.currentTimeMillis();

        String sign = null;
        try {
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=8263a928752839e5e12f096568fb3c2ba3eb045c676d2486eb91060411bedd8d&timestamp="+timestamp+"&sign="+sign);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        //文本方式
//        request.setMsgtype("text");
//        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
//        text.setContent("想回到过去");
//        request.setText(text);
        //链接形式
//        request.setMsgtype("link");
//        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
//        link.setMessageUrl("https://www.baidu.com/");
//        link.setPicUrl("https://t7.baidu.com/it/u=3635362084,1992212334&fm=193&f=GIF");
//        link.setTitle("时间的火车向前开");
//        link.setText("你的声音失去平衡，慢慢下沉，想回到过去");
//        request.setLink(link);
        //markdown
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("北京天气");
        markdown.setText("#### 北京天气 @党武\n" +
                "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
                "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n"  +
                "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
        request.setMarkdown(markdown);

        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList("17310503610"));
// isAtAll类型如果不为Boolean，请升级至最新SDK
        at.setIsAtAll(true);
        request.setAt(at);




        try {
            OapiRobotSendResponse execute = client.execute(request);
            System.out.println("=====================================execute:"+JSON.toJSONString(execute));
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

//    private String getSign(String secret){
//        Long timestamp = System.currentTimeMillis();
//
//        String sign = null;
//        try {
//            String stringToSign = timestamp + "\n" + secret;
//            Mac mac = Mac.getInstance("HmacSHA256");
//            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
//            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
//            sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
//        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return sign;
//    }

    public static void main(String[] args) {
        sendMsg();
    }
}
