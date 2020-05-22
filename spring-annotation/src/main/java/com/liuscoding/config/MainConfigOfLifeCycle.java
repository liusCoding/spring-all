package com.liuscoding.config;

import com.liuscoding.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期
 *      bean创建---初始化----消耗的过程
 *
 *
 * 容器管理 bean 的生命周期:
 * 我们可以自定义初始化和销毁方法；容器在 bean 中进行到当前生命周期的时候来调用我们的自定义的初始化和销毁方法
 *
 * 构造（对象创建）
 *      单实例： 在容器启动的时候创建对象
 *      多实例： 在每次获取的时候创建对象
 *初始化：
 *     对象创建完成，并赋值好，调用初始化方法
 *
 *销毁：
 *     单实例：容器关闭的时候进行销毁
 *     多实例：容器不会管理这个bean  容器不会调用销毁方法
 *
 * 1. 指定初始化和销毁方法   init-method="" destroy-method=""
 *      通过@Bean指定  init-method="" 和 destroy-method=""
 * @author: liusCoding
 */
@Configuration
public class MainConfigOfLifeCycle {

   // @Scope("prototype")
    @Bean(value = "car",initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
