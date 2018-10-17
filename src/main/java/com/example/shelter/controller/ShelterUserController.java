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

    public void isRegister(){

        // 是否注册过
    }

    public void userLogin(){

        // 通过wechat登陆

        // 获取相关wechat的数据

        // 用户数据落库

    }

    // 可跳过
    public void createResourceNeedLable(){

        // 创建用户需求标签--针对资源的
    }

    // 可跳过
    public void createUserSelfLable(){

        // 创建用户自身的标签
    }





}
