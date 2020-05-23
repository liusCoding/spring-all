package com.liuscoding.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @className: UserService
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 14:03
 */

@Service
public class UserService {

    @EventListener(classes={ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("UserService。。监听到的事件："+event);
    }

}