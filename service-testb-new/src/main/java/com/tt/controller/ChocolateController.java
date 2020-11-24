package com.tt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chocolate")
public class ChocolateController {

    @RequestMapping("/getChocolateInfo")
    @ResponseBody
    public String getChocolateInfo(){
        return "testb-new chocolate";
    }
}
