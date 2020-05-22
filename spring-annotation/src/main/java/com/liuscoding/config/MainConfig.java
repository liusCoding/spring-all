package com.liuscoding.config;

import com.liuscoding.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration  告诉spring这是一个配置类
 * 配置类==配置文件
 * @author: liusCoding
 * @create: 2020-05-22 09:13
 */

@Configuration
public class MainConfig {

    /**
     * @Bean 注解
     * 给容器中注册一个Bean;类型为返回值类型，id默认是用方法名作为id
     *  @Bean("person") 指定id，则为指定名称
     *
     */
    @Bean("person")
    public Person person01(){
        return new Person("lisi",19);
    }
}
