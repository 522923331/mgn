package com.tt.controller;

import com.tt.entity.Attr;
import com.tt.service.ShopService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/getRoomInfo")
    @ResponseBody
    public String getRoomInfo(){
        return "testb getRoomInfo";
    }

    @PostMapping("/findRoom")
    @ResponseBody
    public String findRoom(){
        return "testb findRoom";
    }

    @PostMapping("/getAttr/{id}")
    @ResponseBody
    public Attr getAttr(@PathVariable("id") Long id){
        return shopService.queryAttr(id);
    }
}
