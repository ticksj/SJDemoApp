package com.sj.e_2_develop_idea.workflow;

/**
 * 1. 工作流决定什么时候开始
 * 2. 工作内容决定什么时候结束
 */
public class Work {
    String workId;
    Worker worker;
    WorkCallback callback;
    public Work(String workId, Worker worker) {
        this.workId = workId;
        this.worker = worker;
    }

    /**
     * 工作流 调用用于开始执行工作
     * @param callback
     */
    public void doWork(WorkCallback callback) {
        this.callback=callback;
        worker.workDuties(this);
    }

    /**
     * 外部传递具体工作内容后，调用用于结束当前任务
     */
    public void workComplete(){
        if (callback != null) {
            callback.onComplete();
        }
    }


    public interface WorkCallback {
        void onComplete();
    }

    public interface Worker{
        void workDuties(Work work);
    }
}