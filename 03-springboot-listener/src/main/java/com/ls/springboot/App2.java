package com.ls.springboot;

import com.ls.springboot.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App2 {

    public static void main(String [] args){
        SpringApplication.run(App2.class,args);
    }

    /**
     * 注册listener
     */

    @Bean
    public ServletListenerRegistrationBean<SecondListener>  getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
        return  bean;
    }

}
