package com.liuscoding.controller;

import com.liuscoding.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @className: BookController
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:30
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;


    public void print(){
        System.out.println(bookService);
    }
}
