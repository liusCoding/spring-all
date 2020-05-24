package com.liuscoding.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @className: RootConfig
 * @description:
 * @author: liusCoding
 * @create: 2020-05-24 12:48
 */


//Spring的容器不扫描controller;父容器
@ComponentScan(value="com.liuscoding",excludeFilters={
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes={Controller.class})
})
public class RootConfig {
}
