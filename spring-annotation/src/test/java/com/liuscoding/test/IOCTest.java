package com.liuscoding.test;

import com.liuscoding.config.MainConfig;
import com.liuscoding.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @className: IOCTest
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:33
 */

public class IOCTest {

    @Test
    public void testComponentScanForMainConfig(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }


    @Test
    public void testComponentScanForMainConfig2(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("容器创建");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
        Object person = applicationContext.getBean("person");

        for (int i = 0; i < 10; i++) {
            System.out.println(applicationContext.getBean("person")==person);
        }
    }
}
