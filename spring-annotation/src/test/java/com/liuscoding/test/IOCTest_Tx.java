package com.liuscoding.test;

import com.liuscoding.tx.TxConfig;
import com.liuscoding.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @className: IOCTest_Tx
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 11:19
 */

public class IOCTest_Tx {

    @Test
    public void testForTx(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
        applicationContext.close();
    }
}
