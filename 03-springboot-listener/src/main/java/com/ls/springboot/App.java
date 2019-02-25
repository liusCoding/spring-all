package com.ls.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springboot整合Listener方式一
 */

@SpringBootApplication
@ServletComponentScan
public class App {

    public static void main(String [] args){
        SpringApplication.run(App.class,args);
    }

}
