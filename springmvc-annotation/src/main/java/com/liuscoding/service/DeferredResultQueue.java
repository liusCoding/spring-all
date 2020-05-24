package com.liuscoding.service;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @className: DeferedResultQueue
 * @description:
 * @author: liusCoding
 * @create: 2020-05-24 14:31
 */

public class DeferredResultQueue {

    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedDeque<>();


    public static void save(DeferredResult<Object> deferredResult){
        queue.add(deferredResult);
    }

    public static DeferredResult<Object> get(){
        return queue.poll();
    }
}
