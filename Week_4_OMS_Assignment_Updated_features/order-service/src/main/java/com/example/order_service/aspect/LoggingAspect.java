package com.example.order_service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.orderservice.service.*.*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println(
                "Method: " + joinPoint.getSignature().getName() +
                        " executed in " + (end - start) + " ms"
        );

        return result;
    }
}
