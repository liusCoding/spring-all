package com.liuscoding.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @className: MyApplicationListener
 * @description:
 * @author: liusCoding
 * @create: 2020-05-23 13:56
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    /**
     * Handle an application event.
     * 当容器中发布此事件以后，方法触发
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到的事件"+ event);
    }
}
