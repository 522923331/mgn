package com.tt.controller;

import com.tt.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${dingTalk.webHook}")
    private String webHook;
    @Value("dingTalk.other")
    private String other;
    @Value("${dingTalk.three}")
    private String three;

    @PostMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo() {
        return "testa-new getUserInfo";
    }

    @PostMapping("/findUserInfo")
    @ResponseBody
    public String findUserInfo() {
        return "testa-new findUserInfo";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public User getUser(User user) {
        log.info("user:{}", user);
        return user;
    }

    @PostMapping("/postUser")
    @ResponseBody
    public User postUser(@RequestBody User user) {
        log.info("user:{}", user);
        return user;
    }

    @GetMapping("/getYmlValue")
    @ResponseBody
    public String getYmlValue(@RequestParam("type") int type) {
        if (type == 1) {
            return webHook;
        } else if (type == 2) {
            return other;
        } else {
            return three;
        }
    }

}
