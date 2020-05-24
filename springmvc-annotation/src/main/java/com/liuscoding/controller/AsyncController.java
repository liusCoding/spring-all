package com.liuscoding.controller;

import com.liuscoding.service.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @className: AsyncController
 * @description:
 * @author: liusCoding
 * @create: 2020-05-24 14:04
 */
@Controller
public class AsyncController {

    @RequestMapping("/createOrder")
    @ResponseBody
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> deferredResult = new DeferredResult<>(3000L,"create fail");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }


    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        //创建订单
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success===>"+order;
    }

    /**
     * 1、控制器返回Callable
     * 2、Spring异步处理，将Callable 提交到 TaskExecutor 使用一个隔离的线程进行执行
     * 3、DispatcherServlet和所有的Filter退出web容器的线程，但是response 保持打开状态；
     * 4、Callable返回结果，SpringMVC将请求重新派发给容器，恢复之前的处理；
     * 5、根据Callable返回的结果。SpringMVC继续进行视图渲染流程等（从收请求-视图渲染）。
     *
     preHandle.../springmvc_annotation_war_exploded/async
     主线程开始。。。http-nio-8080-exec-7==>1590300654974
     主线程结束。。。http-nio-8080-exec-7==>1590300654974

     =========DispatcherServlet及所有的Filter退出线程============================

     ================等待Callable执行==========
     子线程开始。。。MvcAsync1==>1590300655004
     子线程结束。。。MvcAsync1==>1590300657005
     ================Callable执行完成==========

     ================再次收到之前重发过来的请求========
     preHandle.../springmvc_annotation_war_exploded/async
     postHandle...        （Callable的之前的返回值就是目标方法的返回值）
     afterCompletion..
     异步的拦截器:
     1）、原生API的AsyncListener
     2）、SpringMVC：实现AsyncHandlerInterceptor；
     * @return
     */
    @ResponseBody
    @RequestMapping("/async")
    public Callable<String> async(){

        System.out.println("主线程开始。。。"+Thread.currentThread().getName()+"==>"+System.currentTimeMillis());

        Callable<String> callable = () ->{
            System.out.println("子线程开始。。。"+Thread.currentThread().getName()+"==>"+System.currentTimeMillis());

            Thread.sleep(2000L);
            System.out.println("子线程结束。。。"+Thread.currentThread().getName()+"==>"+System.currentTimeMillis());

            return " Callable<String> async()";

        };

        System.out.println("主线程结束。。。"+Thread.currentThread().getName()+"==>"+System.currentTimeMillis());

        return callable;
    }
}
