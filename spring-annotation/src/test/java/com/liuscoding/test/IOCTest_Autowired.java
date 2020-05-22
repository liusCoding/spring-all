package com.liuscoding.test;

import com.liuscoding.bean.Boss;
import com.liuscoding.bean.Car;
import com.liuscoding.bean.Color;
import com.liuscoding.bean.Red;
import com.liuscoding.config.MainConfigOfAutowired;
import com.liuscoding.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @className: IOCtest_LifeCycle
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 21:24
 */

public class IOCTest_Autowired {

    @Test
    public void testForAutowired(){

        //1.创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        printBeans(applicationContext);

        System.out.println("IOC 容器创建完成");

        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = applicationContext.getBean(Car.class);

        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        Red bean = applicationContext.getBean(Red.class);
        System.out.println(bean);

    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
