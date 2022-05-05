package com.tzzh.taskrwzl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: PCJ
 * @Create: 2022-05-05 14:34
 * @Description:
 **/
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/test1")
    public String getTest(){
        return "----success-----";
    }

}
