package com.liuscoding.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: UserService
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 11:18
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public void insertUser(){
        userDao.insert();
        System.out.println("----------插入完成-------");

        int i = 1/0;
    }
}
