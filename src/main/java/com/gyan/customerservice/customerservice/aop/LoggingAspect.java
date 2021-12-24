package com.gyan.customerservice.customerservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.gyan.customerservice.customerservice..*.*(..))")
    public Object log(ProceedingJoinPoint pip)throws Throwable{
        System.out.println("aop code is invoked"+pip.toString());
        Object object = pip.proceed();

        return object;
    }
}
