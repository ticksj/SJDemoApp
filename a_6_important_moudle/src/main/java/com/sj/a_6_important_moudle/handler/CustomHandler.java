package com.sj.a_6_important_moudle.handler;

/**
 * Created by SJ on 2020/2/10.
 */
public class CustomHandler {
    final CustomLooper looper;
    final CustomMessageQueue messageQueue;
    public CustomHandler() {
        //获取当前线程唯一的Looper  不能new 的原因 保证唯一
        this.looper = CustomLooper.myLooper();
        //获取当前线程唯一的MessageQueue
        this.messageQueue = looper.mQueue;
    }
    /**
     * 发送消息
     */
    public void sendMessage(CustomMessage customMessage) {
        enqueueMessage(customMessage);
    }
    /**
     * 插入消息至消息队列
     * @param message
     */
    public void enqueueMessage(CustomMessage message) {
        //将handler与消息做绑定
        message.target = this;
        messageQueue.enqueueMessage(message);
    }
    /**
     * 分发消息
     * @param message
     */
    public void dispatchMessage(CustomMessage message) {
        handleMessage(message);
    }
    /**
     * 处理消息
     * @param message
     */
    public void handleMessage(CustomMessage message) {

    }

}
