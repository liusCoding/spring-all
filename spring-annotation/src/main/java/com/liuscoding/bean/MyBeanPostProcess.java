package com.liuscoding.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * 后置处理器： 初始化前后进行处理工作
 * 将后置处理器加入到容器中
 * @author  liuscoding
 */
@Component
public class MyBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        System.out.println("postProcessBeforeInitialization"+s +"--->" + o);

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

        System.out.println("postProcessAfterInitialization"+s +"--->" + o);
        return o;
    }
}
