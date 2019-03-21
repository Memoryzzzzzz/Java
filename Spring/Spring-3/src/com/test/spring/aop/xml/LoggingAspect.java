package com.test.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

public class LoggingAspect {

    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
    }

    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception " + ex);
    }

    @Around("execution(public int com.test.spring.aop.ArithmeticCalculator.*(..))")
    public Object aroudMethod(ProceedingJoinPoint pjd) {

        Object result = null;
        String methodName = pjd.getSignature().getName();

        // 执行目标方法
        try {
            // 前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            // 执行目标方法
            result = pjd.proceed();
            // 返回通知
            System.out.println("The method ends with " + result);
        } catch (Throwable e) {
            // 异常通知
            System.out.println("The method " + methodName + " occurs exceptio：" + e);
            throw new RuntimeException(e);
        }
        // 后置通知
        System.out.println("The method " + methodName + " ends");

        return result;
    }

}
