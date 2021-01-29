package com.tt.controller;

import com.tt.enums.RedisKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @PostMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request) {
        System.out.println(request);
        String header = request.getHeader("X-Request-Foo");
        System.out.println("X-Request-Foo=" + header);
        return "testa getUserInfo";
    }

    @PostMapping("/findUserInfo")
    @ResponseBody
    public String findUserInfo() {
        return "testa findUserInfo";
    }

    public static void main(String[] args) {
        int backCateId = 123;
        String s = RedisKeyEnum.BACK_CATE_ATTR.getKey() + backCateId;
        System.out.println(s);

        method1(10);
    }

    private static void method1(int i){
        System.out.println("method1"+i);
        method2(i);
    }

    private static void method2(int i){
        i++;
        System.out.println("method2"+ i);
    }
}
