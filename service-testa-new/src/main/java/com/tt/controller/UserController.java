package com.tt.controller;

import com.alibaba.fastjson.JSON;
import com.tt.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(){
        return "testa-new getUserInfo";
    }

    @PostMapping("/findUserInfo")
    @ResponseBody
    public String findUserInfo(){
        return "testa-new findUserInfo";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public User getUser(User user){
        log.info("user:{}",user);
        return user;
    }

    @PostMapping("/postUser")
    @ResponseBody
    public User postUser(@RequestBody User user){
        log.info("user:{}",user);
        return user;
    }


}
