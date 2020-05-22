package com.liuscoding.test;

import com.liuscoding.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @className: IOCtest_LifeCycle
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 21:24
 */

public class IOCTest_LifeCycle {

    @Test
    public void testForLifeCycle(){

        //1.创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("IOC 容器创建完成");


        //Object car = applicationContext.getBean("car");

       // Object cat = applicationContext.getBean("cat");
        //关闭容器
        applicationContext.close();
    }
}
