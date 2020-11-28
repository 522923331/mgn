package com.tt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @PostMapping("/getRoomInfo")
    @ResponseBody
    public String getRoomInfo(){
        return "testb-new getRoomInfo";
    }

    @PostMapping("/fingRoom")
    @ResponseBody
    public String fingRoom(){
        return "testb-new fingRoom";
    }
}
