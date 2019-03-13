package com.test.sping.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        // 1. 创建 Spring 的 IOC 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 从 IOC 容器中获取 Bean 实例
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWord");

        // 3. 调用 hello 方法
        helloWorld.hello();
    }
}
