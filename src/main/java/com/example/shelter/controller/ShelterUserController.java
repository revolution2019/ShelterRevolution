package com.example.shelter.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.shelter.service.ShelterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShelterUserController {

    @Autowired
    private ShelterUserService shelterUserService;

    @RequestMapping("/shelterUser/{id}")
    public String selectUser(@PathVariable Long id) {
        return JSONObject.toJSONString(shelterUserService.selectUser(id));

    }
}
