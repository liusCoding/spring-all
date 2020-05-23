package com.liuscoding.test;

import com.liuscoding.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @className: IOCTest_Ext
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 13:00
 */

public class IOCTest_Ext {

    @Test
    public void testForExt(){
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);
        //发布事件；
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")) {
        });

        applicationContext.close();
    }


}
