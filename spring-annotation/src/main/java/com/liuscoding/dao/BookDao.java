package com.liuscoding.dao;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Repository;

/**
 * @className: BookDao
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:31
 */
@Repository
//名称默认是类名首字母小写
@Data
@ToString
public class BookDao {

    private String label = "1";
}
