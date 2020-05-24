package com.liuscoding.controller;

import com.liuscoding.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: HelloController
 * @description:
 * @author: liusCoding
 * @create: 2020-05-24 12:51
 */

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){

        String tomcat = helloService.sayHello("tomcat.....");
        return tomcat+ "success";
    }


    @RequestMapping("/suc")
    public String success(){
        return "success";
    }
}
