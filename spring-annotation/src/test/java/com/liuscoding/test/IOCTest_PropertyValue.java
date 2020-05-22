package com.liuscoding.test;

import com.liuscoding.bean.Person;
import com.liuscoding.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.stream.Stream;

/**
 * @className: IOCtest_LifeCycle
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 21:24
 */

public class IOCTest_PropertyValue {

    @Test
    public void testForPropertyValue(){

        //1.创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        System.out.println("IOC 容器创建完成");

        printBeans(applicationContext);

        System.out.println("================分割线=====================");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
