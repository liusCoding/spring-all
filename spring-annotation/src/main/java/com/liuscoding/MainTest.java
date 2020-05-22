package com.liuscoding;

import com.liuscoding.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @className: MainTest
 * @description: 测试
 * @author: liusCoding
 * @create: 2020-05-22 09:06
 */

public class MainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

    }
}
