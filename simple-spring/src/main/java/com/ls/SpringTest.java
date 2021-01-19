package com.ls;

import com.ls.config.AppConfig;
import com.ls.spring.ApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);
        Object bean = applicationContext.getBean("userService");
        Object bean1 = applicationContext.getBean("userService");
        Object bean2 = applicationContext.getBean("orderService");
        System.out.println(bean2);
        System.out.println(bean);
        System.out.println(bean1);
    }
}
