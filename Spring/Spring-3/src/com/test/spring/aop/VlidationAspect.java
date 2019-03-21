package com.test.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class VlidationAspect {

    @Before("com.test.spring.aop.LoggingAspect.declareJoinPointExpression()")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("--> validate：" + Arrays.asList(joinPoint.getArgs()));
    }

}
