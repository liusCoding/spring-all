package com.ls.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 之前的配置方式
 *  <servlet>
 *      <servlet-name>FirstServlet</servlet-name>
 *      <servlet-class>com.ls.springboot.servlet.FirstServlet</servlet-class>
 *  </servlet>
 *
 *  <servlet-mapping>
 *      <servlet-name>FirstServlet</servlet-name>
 *      <url-pattern>/first</url-pattern>
 *  </servlet-mapping>
 */

//springboot的第一种配置方式
@WebServlet(name="FirstServlet",urlPatterns="/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is my  FirstServlet");
        super.doGet(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
