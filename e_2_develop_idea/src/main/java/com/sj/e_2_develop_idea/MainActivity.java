package com.sj.e_2_develop_idea;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.e_2_develop_idea.workflow.Work;
import com.sj.e_2_develop_idea.workflow.WorkFlow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.hello_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFlow();
            }
        });
    }

    /**
     * 工作流方式：方便任务间的调整，消除强耦合
     * 参考链接：https://mp.weixin.qq.com/s/sKRe_jyFBYEDIKdgjz7rZQ
     */
    private void startFlow() {
        WorkFlow workFlow = new WorkFlow(new WorkFlow.WorkFlowListener() {
            @Override
            public void flowEnd(String msg) {
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        workFlow.addWork(new Work("1", new Work.Worker() {
            @Override
            public void workDuties(Work work) {
                Toast.makeText(MainActivity.this,"Task 1",Toast.LENGTH_SHORT).show();
                //具体任务--完成后调用完成
                work.workComplete();
            }
        }));
        workFlow.addWork(new Work("2", new Work.Worker() {
            @Override
            public void workDuties(Work work) {
                Toast.makeText(MainActivity.this,"Task 2",Toast.LENGTH_SHORT).show();
                //具体任务--完成后调用完成
                work.workComplete();
            }
        }));
        workFlow.addWork(new Work("4", new Work.Worker() {
            @Override
            public void workDuties(Work work) {
                Toast.makeText(MainActivity.this,"Task 4",Toast.LENGTH_SHORT).show();
                //具体任务--完成后调用完成
                work.workComplete();
            }
        }));
        workFlow.addWork(new Work("3", new Work.Worker() {
            @Override
            public void workDuties(Work work) {
                Toast.makeText(MainActivity.this,"Task 3",Toast.LENGTH_SHORT).show();
                //具体任务--完成后调用完成
                work.workComplete();
            }
        }));
        workFlow.startWork();
    }
}
