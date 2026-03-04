package com.example.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class TestController1 {

    @GetMapping
    public String testAop(){
        System.out.println("This is inside");
        return "Starting AOP";
    }

    @GetMapping("/get1")
    public String testAop1(){
        System.out.println("This is inside AOP1");
        return "Starting AOP";
    }

    @GetMapping("/get2")
    public String testAop2(){
        System.out.println("This is inside AOP2");
        return "Starting AOP";
    }
}
