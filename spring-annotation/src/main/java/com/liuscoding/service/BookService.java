package com.liuscoding.service;

import com.liuscoding.dao.BookDao;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @className: BookService
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:31
 */
@Service
@ToString
public class BookService {

    @Autowired(required = false)
    @Qualifier("bookDao")
    private BookDao bookDao;


    public void print(){
        System.out.println(bookDao);
    }
}
