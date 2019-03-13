/*package com.example.SpringBoot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Component
@Aspect  
public class CaptureLogUtil {
    private static final Logger logger  = LoggerFactory.getLogger(CaptureLogUtil.class);

    @Pointcut("@annotation(com.example.SpringBoot.util.CaptureLog)")
    public void methodCachePointcut() {

    }

    

    @Around("methodCachePointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        for (Object object : args) {
            logInfo(object,0);

        }
         Object object;
         try {
             object = point.proceed();
         } catch (Exception e) {
             throw e;
         }
         logInfo(object,1);
         return object;

    }
    public void logInfo(Object object, Integer i) {
        String logType = "";
        if(i == 0) {
            logType = "输入参数：";
            }else {
                logType = "输出参数：";
                }
        if(object == null) {
            logger.info(logType+"为null");
        }else {
            logger.info(logType+object.toString());
        }
    }
 
}
*/