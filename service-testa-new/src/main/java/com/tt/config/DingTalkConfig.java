package com.tt.config;

import com.dingtalk.api.DefaultDingTalkClient;
import com.tt.util.DingTalkSupport;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dangwu
 * @since 2021/3/8 4:28 下午
 */
@Data
@Configuration
public class DingTalkConfig {
    @Value("${dingTalk.webHook}")
    private String webHook;

    @Bean
    public DingTalkSupport getDingTalkSupport() {
        return new DingTalkSupport(new DefaultDingTalkClient(webHook));
    }
}
