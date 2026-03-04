package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

//    @Before("execution(public String com.example.aop.controller.TestController.testAop())")
//    public void testMethod(){
//        System.out.println("This is a start of the method");
//    }
//
//    @After("execution(public String com.example.aop.controller.TestController.testAop())")
//    public void endMethod(){
//        System.out.println("This is the end of a method");
//    }

    //within -> used to imply for all the methods in a specified class
    @Before("within(com.example.aop.controller.*)")
    public void withMethod(){
        System.out.println("This is a start of the method of with");
    }

    @Before("@within(org.springframework.stereotype.Service)")
    public void empMethod(){
        System.out.println("This is start of service method annotation");
    }

    @Around("execution(* com.example.aop.controller.*.*(..))")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + "ms");
        return result;
    }

}
