package com.liuscoding.test;

import com.liuscoding.bean.Blue;
import com.liuscoding.bean.Person;
import com.liuscoding.config.MainConfig;
import com.liuscoding.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @className: IOCTest
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:33
 */

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testComponentScanForMainConfig(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }


    @Test
    public void testComponentScanForMainConfig2(){
        System.out.println("容器创建");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
        Object person = applicationContext.getBean("person");

        for (int i = 0; i < 10; i++) {
            System.out.println(applicationContext.getBean("person")==person);
        }
    }

    @Test
    public void testForConditional(){

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值： Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);

        Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
        personMap.forEach((k,v) -> System.out.println("key:"+k +"----->"+"value:"+ v));
    }

    @Test
    public void testForImport(){
        printBeans(applicationContext);

        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
