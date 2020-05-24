package com.liuscoding.service;

import org.springframework.stereotype.Service;

/**
 * @className: HelloService
 * @description:
 * @author: liusCoding
 * @create: 2020-05-24 12:52
 */

@Service
public class HelloService {

    public String sayHello(String name){
        return "Hello:"+name;
    }
}
