package com.ls.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

//Spring整合Filter方式二
public class SecondFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入Filter。。。");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开Filter...");
    }

    @Override
    public void destroy() {

    }
}
