package com.liuscoding.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 * @author: liusCoding
 */

public class ColorFactoryBean implements FactoryBean<Color> {


    /**
     *
     * @return  返回一个Color对象，这个对象会添加到容器中
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...........");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }


    /**
     * 是否是单例
     *
     * true :这个bean是单实例
     * false: 多实例，每次获取都会创建一个新的bean
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
