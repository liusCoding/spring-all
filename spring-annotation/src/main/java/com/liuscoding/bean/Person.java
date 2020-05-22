package com.liuscoding.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @className: Person
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:00
 */

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Person {

    /**
     * 使用@Value赋值
     * 1.基本数值
     * 2.可以写SpEl表达式： #{}
     * 3.可以写${}：取出配置文件中的值（[properties文件]在运行环境变量里面的值）
     */

    @Value("张三")
    private String name;

    @Value("#{20-1}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;


    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }
}
