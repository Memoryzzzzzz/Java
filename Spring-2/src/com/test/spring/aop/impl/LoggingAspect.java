package com.test.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// 把这个类声明为一个切面： 需要把该类放入 IOC 容器中、在声明为一个切面
@Aspect
@Component
public class LoggingAspect {

    // 声明该方法是一个前置通知：在目标方法开始之前执行
    @Before("execution(public int com.test.spring.aop.impl.ArithmeticCalculator.*(int, int))")
    public void beforeMothod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("The method " + methodName + " begins with " + args);
    }

}
