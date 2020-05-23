package com.liuscoding.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    public void insertUser(){
        userDao.insert();
        System.out.println("----------插入完成-------");

        int i = 1/0;
    }
}
