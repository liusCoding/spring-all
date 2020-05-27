package com.liuscoding.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @className: com.liuscoding.gmall.UserApplication
 * @description:
 * @author: liusCoding
 * @create: 2020-05-27 19:25
 */

public class UserApplication {



    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
        ioc.start();

        System.in.read();
    }

}
