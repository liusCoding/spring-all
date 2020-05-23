package com.liuscoding.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @className: MyBeanFactoryPostProcessor
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 12:56
 */

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("-------------MyBeanFactoryPostProcessor-->--------postProcessBeanFactory");
        int count = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("---共有"+count+"-------个Bean");
        System.out.println(Arrays.asList(beanDefinitionNames));
    }
}
