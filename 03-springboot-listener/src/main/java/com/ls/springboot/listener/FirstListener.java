package com.ls.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * springboot整合listener方式一
 *
 * 之前的配置方式
 * <listener>
 *     <listener-class>com.ls.springboot.listener.FirstListener</listener-class>
 * </listener>
 */
@WebListener
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener ... init ....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
