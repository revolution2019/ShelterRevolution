package com.example.shelter.controller;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供资源查询
 *
 * 这里主要是房源查询
 */
@RestController
public class ShelterResourceController {

    public void submitResourceInfo(){

        // 上传资源信息到服务器
    }

    public void modifyResourceInfo(){

        // 修改服务器上资源信息
    }

    public void deleteResourceInfo(){

        // 删除资源信息

    }

    public List queryResourceInfo(){

        // 根据用户需求标签查询资源列表

        return null;
    }

    public void collectResource(){

        // 收藏资源
    }

    public List queryCollectionsByUser(){

        // 查询用户的资源收藏
        return null;
    }

    public void admireResource(){

        // 点赞资源
    }

}
