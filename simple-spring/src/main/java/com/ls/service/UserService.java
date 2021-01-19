package com.ls.service;

import com.ls.spring.BeanPostProcessor;
import com.ls.spring.Component;

@Component("userService")
public class UserService implements BeanPostProcessor {
    @Override
    public void postProcessBeforeInitialization(String beanName, Object bean) {

    }

    @Override
    public void postProcessAfterInitialization(String beanName, Object bean) {
        System.out.println("postProcessAfterInitialization");
    }
}
