package com.sj.e_1_develop_construct.mvc;

import android.view.View;
import android.widget.TextView;

/**
 * Created by SJ on 2020/2/3.
 */
public class MVCSimple {
    //实际开发中Activity既承担了View的角色又承担了Controller的角色
    //activity既控制页面元素应显示的数据或其他更改，又决定了视图操作之后需要进行的逻辑处理
    class Modeler{
        Viewer viewer;
        public Modeler(Viewer viewer) {
            this.viewer = viewer;
        }

        public void requestData() {
            viewer.refreshView("获取到的数据");
        }
    }
    class Viewer{
        TextView tv;
        Controller controller;

        public Viewer(TextView tv, final Controller controller) {
            this.tv = tv;
            this.controller = controller;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickTV();
                }
            });
        }

        private void clickTV() {
            controller.userOperation(tv);
        }

        public void refreshView(Object data){
            tv.setText("数据进行视图更新");
        }
    }
    class Controller{
        Modeler modeler;

        public Controller(Modeler modeler) {
            this.modeler = modeler;
        }

        public void userOperation(View v){
            switch (v.getId()) {
                //....
                default:
                    modeler.requestData();
            }
        }
    }
}
