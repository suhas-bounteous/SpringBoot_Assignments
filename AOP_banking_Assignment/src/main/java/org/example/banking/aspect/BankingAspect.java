package org.example.banking.aspect;

import org.example.banking.service.BankService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankingAspect {

    @Before("execution(* com.example.banking.service.*.*(..))")
    public void logExecution(JoinPoint joinPoint) {
        System.out.println("Executing service method: "
                + joinPoint.getSignature().getName());
    }

    @Before("within(com.example.banking.service..*)")
    public void logWithinPackage() {
        System.out.println("Method inside service package invoked");
    }

    @Before("@within(org.springframework.stereotype.Service)")
    public void logServiceAnnotatedClass() {
        System.out.println("Class annotated with @Service executed");
    }

    @Before("target(com.example.banking.service.BankService)")
    public void logTargetBankService() {
        System.out.println("Target object is BankService");
    }

    @Before("@annotation(com.example.banking.annotation.TrackExecution)")
    public void logTrackExecution() {
        System.out.println("Tracked method executed");
    }
}
