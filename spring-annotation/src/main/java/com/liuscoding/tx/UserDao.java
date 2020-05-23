package com.liuscoding.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @className: UserDao
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 11:14
 */

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into `user1` (user_name,over) values(?,?)";

        String username = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,username,"多占佛");
    }
}
