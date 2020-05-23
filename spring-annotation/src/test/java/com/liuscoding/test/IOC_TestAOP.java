package com.liuscoding.test;

import com.liuscoding.aops.MathCalculator;
import com.liuscoding.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @className: IOC_TestAop
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 08:49
 */

public class IOC_TestAOP {

    @Test
    public void testForAOP(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        int div = bean.div(1, 0);

        applicationContext.close();
    }
}
