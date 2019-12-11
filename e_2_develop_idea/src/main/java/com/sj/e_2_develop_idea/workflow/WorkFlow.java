package com.sj.e_2_develop_idea.workflow;

import java.util.ArrayList;
import java.util.List;

public class WorkFlow {
    public WorkFlow(WorkFlowListener workFlowListener) {
        this.workFlowListener = workFlowListener;
    }

    WorkFlowListener workFlowListener;
    List<Work> works = new ArrayList<>();

    public void startWork() {
        if (works == null || works.isEmpty()) {
            workFlowListener.flowEnd("任务均已完成");
            return;
        }
        works.get(0).doWork(new Work.WorkCallback() {
            @Override
            public void onComplete() {
                works.remove(0);
                startWork();
            }
        });
    }

    public void addWork(Work work) {
        works.add(work);
    }

    public interface WorkFlowListener {
        void flowEnd(String msg);
    }
}