package com.liuscoding.test;

import com.liuscoding.bean.Blue;
import com.liuscoding.ext.ExtConfig;
import org.junit.Test;
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
        Blue blue = applicationContext.getBean(Blue.class);
        System.out.println(blue);
    }


}
