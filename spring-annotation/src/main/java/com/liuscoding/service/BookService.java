package com.liuscoding.service;

import com.liuscoding.dao.BookDao;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @className: BookService
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 09:31
 */
@Service
@ToString
public class BookService {

//    @Autowired(required = false)
//    @Qualifier("bookDao")
//    @Resource(name = "bookDao2")
    @Inject
    private BookDao bookDao;


    public void print(){
        System.out.println(bookDao);
    }
}
