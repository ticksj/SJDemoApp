package com.sj.a_6_important_moudle.handler;

/**
 * Created by SJ on 2020/2/10.
 */
public class CustomLooper {
    public CustomMessageQueue mQueue;
    public static ThreadLocal<CustomLooper> sThreadLocal = new ThreadLocal<>();
    private CustomLooper(){
        //只会初始化一次，保证当前线程Looper操作的MessageQueue唯一
        mQueue = new CustomMessageQueue();
    }
    /**
     * 准备工作
     * 初始化当前线程Looper
     */
    public static void prepare(){
        //保证当前线程的Looper唯一
        if (sThreadLocal.get()!=null) {
            throw new RuntimeException("线程只能有一个CustomLooper");
        }
        sThreadLocal.set(new CustomLooper());
    }
    /**
     * 获取当前线程Looper
     */
    public static CustomLooper myLooper() {
        return sThreadLocal.get();
    }
    /**
     * 启动looper，开始操作MessageQueue
     */
    public static void loop(){
        final CustomLooper myLooper = myLooper();
        final CustomMessageQueue mQueue = myLooper.mQueue;
        for (;;){
            CustomMessage message = mQueue.next();
            if (message != null) {
                message.target.dispatchMessage(message);
            }
        }
    }
}
