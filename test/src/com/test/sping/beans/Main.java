package com.test.sping.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        // 1. 创建 Spring 的 IOC 容器对象
        // ApplicationContext 代表 IOC 容器
        // ClassPathXmlApplicationContext： 是 ApplicationContext 接口的实现类，该实现类路径下来加载配置文件。
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 从 IOC 容器中获取 Bean 实例
        // 利用 id 定位到 IOC 容器中的 bean
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        // 利用类型返回 IOC 容器中的 Bean，但要求 IOC 容器中必须只能有一个该类型的 Bean
//        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        System.out.println(helloWorld);

        // 3. 调用 hello 方法
        helloWorld.hello();

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        car = (Car) ctx.getBean("car2");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        person = (Person) ctx.getBean("person2");
        System.out.println(person);
    }
}
