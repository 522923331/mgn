package com.tt.util;

import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.google.common.base.Splitter;
import com.tt.constant.DingTalkConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dangwu
 * @since 2021/3/4 8:03 下午
 */
@Slf4j
public class DingTalkSupport {

    private static DingTalkClient client;

    public DingTalkSupport(DingTalkClient client) {
        DingTalkSupport.client = client;
    }

    /**
     * 钉钉群消息推送
     *
     * @param content
     *            通讯内容
     * @param tips
     *            提示信息
     * @param atMobiles
     *            通知手机号
     */
    public static void dingTalk(String content, String tips, String atMobiles) {
        try {
            OapiRobotSendRequest request = new OapiRobotSendRequest();
            request.setMsgtype("text");
            OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
            text.setContent(tips + content);
            request.setText(text);
            if (atMobiles != null) {
                OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
                at.setAtMobiles(Splitter.on(",").splitToList(atMobiles));
                request.setAt(at);
            }
            client.execute(request);
        } catch (Exception e) {
            log.error("Alter to DingTalk error.", e);
        }
    }

    public static void dingTalk(String content, String tips) {
        dingTalk(content, tips, null);
    }

    public static void dingTalk(String content) {
        dingTalk(content, DingTalkConstants.ALARM_INFO);
    }
}
