package com.tt.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request){
        System.out.println(request);
        String header = request.getHeader("X-Request-Foo");
        System.out.println("X-Request-Foo="+header);
        return "testa getUserInfo";
    }

    @PostMapping("/findUserInfo")
    @ResponseBody
    public String findUserInfo(){
        return "testa findUserInfo";
    }
}
