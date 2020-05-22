package com.liuscoding.test;

import com.liuscoding.config.MainConfig;
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
    public void testComponentScan(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
