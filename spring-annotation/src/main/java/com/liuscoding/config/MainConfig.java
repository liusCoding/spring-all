package com.liuscoding.config;

import com.liuscoding.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Configuration  告诉spring这是一个配置类
 * 配置类==配置文件
 * @ComponentScan  value：指定要扫描的包
 *
 * excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
 * includeFilters = Filter[] ：指定扫描的时候只需要那些组件
 * FilterType.ANNOTATION:按照注解
 * FilterType.ASSIGNABLE_TYPE：按照指定类型
 * @author: liusCoding
 * @create: 2020-05-22 09:13
 */

@Configuration
@ComponentScan(basePackages = "com.liuscoding",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)

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
