package com.kit.storage;

import com.kit.collect.RequestInfo;

import java.util.concurrent.*;

/**
 * Created by kk on 2020/3/29.
 */
public class RequestQueue {

    private LinkedBlockingQueue<RequestInfo> queue = new LinkedBlockingQueue<RequestInfo>();
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public RequestQueue(final Storage storage) {
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                RequestInfo requestInfo = pop();
                if (requestInfo!=null){
                    storage.save(requestInfo);
                }
            }
        },2,2, TimeUnit.SECONDS);
    }

    public boolean put(RequestInfo requestInfo){
//        queue.add(requestInfo);//抛异常
        boolean rs = queue.offer(requestInfo);//特殊值true、false
        return rs;
    }

    public RequestInfo pop(){
//        return queue.remove();//抛异常
        RequestInfo poll = queue.poll();//特殊值，存在不存在
        return poll;
    }

}
