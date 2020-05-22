package com.liuscoding.config;

import com.liuscoding.bean.Person;
import com.liuscoding.condition.LinuxCondition;
import com.liuscoding.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @className: MainConfig2
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 10:05
 */

@Configuration
public class MainConfig2 {

    /**
     * 默认bean是单例的
     *  String SCOPE_SINGLETON = "singleton"; 单例的 ioc容器启动会调用方法创建对象放到IOC容器中
     *  以后每次获取就是直接从容器map.get()中拿
     *
     *  String SCOPE_PROTOTYPE = "prototype"; 多实例的
     *  IOC容器启动并不会去调用方法创建对象放在容器中，而是每次获取的时候才会调用方法创建对象
     *  request :同一次请求创建一个实例
     *  session：同一个session创建一个实例
     *
     *
     *  懒加载：
     *      单实例bean：默认在容器启动的时候创建对象
     *      懒加载：容器启动不创建对象。第一次使用（获取）Bean创建对象，并初始化。
     *
     */
    @Scope
    @Bean("person")
    @Lazy
    public Person person(){
        System.out.println("给容器中添加Person");
        return new Person("liuscoidng",20);
    }


    /**
     * @Conditional : 按照一定的条件进行判断，满足条件给容器注册bean
     *
     * 如果系统是windows，给容器注册（"bill"）
     *
     * 如果系统是linux，给容器注册（"linus"）
     */
    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person person99(){
        return new Person("bill Gates",60);
    }

    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person person88(){
        return new Person("linus",50);
    }
}
