package com.liuscoding.config;

import com.liuscoding.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: liusCoding
 * @create: 2020-05-22 22:57
 *
 * 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值
 */

@Configuration
@PropertySource(value = {"classpath:person.properties"})
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
