package com.tt.enums;

import java.util.concurrent.TimeUnit;

/**
 * RedisKeyEnum
 *
 * @date 2020/9/2
 */
public enum RedisKeyEnum {

    /**
     * 用户短信验证码
     */
    USER_SMS_CODE("user.sms.code.{phone}", TimeUnit.SECONDS.toSeconds(60 * 5)),
    /**
     * 用户验证码
     */
    USER_VERIFY_CODE("user.verify.code.{sessionId}", TimeUnit.SECONDS.toSeconds(60 * 5)),
    /**
     * 属性分类
     */
    ATTR_CATE_LIST("TTJB:MALL:CACHE:ATTR:CATE:LIST",TimeUnit.SECONDS.toSeconds(60 * 5)),
    /**
     * 属性分类
     */
    BACK_CATE_ATTR("TTJB:MALL:CACHE:BACK:CATE:{backCateId}",TimeUnit.SECONDS.toSeconds(60 * 5)),
    ;


    private String key;
    private long expireTime;

    RedisKeyEnum(String key, long expireTime) {
        this.key = key;
        this.expireTime = expireTime;
    }

    public String getKey() {
        return key;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
