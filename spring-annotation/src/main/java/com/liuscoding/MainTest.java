package com.liuscoding;

import com.liuscoding.bean.Person;
import com.liuscoding.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @className: MainTest
 * @description: 测试
 * @author: liusCoding
 * @create: 2020-05-22 09:06
 */

public class MainTest {

    public static void main(String[] args) {

        /**
         * 1.传统配置文件方式
         */
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);


        /**
         * 2.配置类方式
         */
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        //id 是什么
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

        Stream.of(beanNamesForType).forEach(System.out::println);

    }
}
