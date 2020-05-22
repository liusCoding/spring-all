package com.liuscoding.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @className: Cat
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 21:39
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat  ------------constructor.....");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("car ---------- destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car ---------- afterPropertiesSet");
    }
}
