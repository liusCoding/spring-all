package com.ls.springboot.pojo;

import lombok.Data;

@Data
public class User {
    private Integer userid;

    private String username;

    private Integer userage;

    public User(Integer userid, String username, Integer userage) {
        this.userid = userid;
        this.username = username;
        this.userage = userage;
    }
}
