package com.example.shelter.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * 简单埋点
 *
 * 可以简单内部去处理不需要前端调用
 */
@RestController
public class ShelterSimpleTraceController {


    /**
     * 主要用来检测用户真正的检索标签
     *
     * 往往用户的需求在不断的使用中才会真正表现出来
     */
    public void watchQueryResourceInfo(){

        // 记录查询资源列表时的检索条件

        //
    }

}
