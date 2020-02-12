package com.sj.a_6_important_moudle.handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by SJ on 2020/2/10.
 */
public class CustomMessageQueue {

    BlockingQueue<CustomMessage> queue;//实现仓库的阻塞功能
    public static final int MAX_COUNT = 10;
    public CustomMessageQueue() {
        queue = new ArrayBlockingQueue<>(MAX_COUNT);
    }
    /**
     * 往消息队列添加消息
     * @param message
     */
    public void enqueueMessage(CustomMessage message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 从消息队列取消息
     * @return
     */
    public CustomMessage next() {
        CustomMessage message = null;
        try {
            message = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }
}
