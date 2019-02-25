package com.ls.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * SpringBoot整合Listener方式二
 */
public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondLister...init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
