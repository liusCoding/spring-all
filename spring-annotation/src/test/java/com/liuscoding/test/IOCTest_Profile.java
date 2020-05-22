package com.liuscoding.test;

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
    //1.创建ioc容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

    @Test
    public void testForPropertyValue(){

        //1.创建ioc容器
        System.out.println("IOC 容器创建完成");
       // printBeans(applicationContext);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        Stream.of(beanNamesForType).forEach(System.out::println);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
