package com.liuscoding.test;

import com.liuscoding.bean.Yellow;
import com.liuscoding.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.stream.Stream;

/**
 * @className: IOCTest_Profile
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 07:37
 */

public class IOCTest_Profile {
    //1.使用命令行动态参数，在虚拟机参数位置加载 -Dspring.profiles.active=test

    //2.代码的方式激活某种环境
    @Test
    public void testForPropertyValue(){
        //1.创建ioc容器
       // AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev","test");

        //3.注册配置类
        applicationContext.register(MainConfigOfProfile.class);

        //4.启动刷新容器

        applicationContext.refresh();
        System.out.println("IOC 容器创建完成");
        //printBeans(applicationContext);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        Stream.of(beanNamesForType).forEach(System.out::println);

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
