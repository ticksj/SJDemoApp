package com.sj.e_1_develop_construct.mvp;

import android.view.View;
import android.widget.TextView;

/**
 * Created by SJ on 2020/2/3.
 */
public class MVPSimple {
    //Activity将Controller的职责抽离出来，成为Presenter，这样activity就只有View的职责了
    class Modeler {
        public Object requestData() {
            return "获取数据";
        }
    }

    class Viewer {
        Presenter presenter;
        TextView tv;

        public Viewer(TextView tv) {
            this.tv = tv;
            presenter = new Presenter(this);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickTV();
                }
            });
        }

        private void clickTV() {
            presenter.load();
        }

        public void refreshView(Object data) {
            tv.setText("数据进行视图更新");
        }
    }

    class Presenter {
        Viewer viewer;
        Modeler modeler;

        public Presenter(Viewer viewer) {
            this.viewer = viewer;
        }

        public void load() {
            modeler = new Modeler();
            Object data = modeler.requestData();
            viewer.refreshView(data);
        }
    }


    //模块功能完整的拆开方便 面向接口编程
    interface IModeler {
         Object requestData();
    }

    interface IViewer {
         void refreshView(Object data);
    }

    interface IPresenter {

         void load();
    }

    //MVC MVP 都可以拆开 职责分离 解耦合
    //主要区别 MVC在Android开发中被惯性认为是VC均由Activity承担的一种变种，实际MVC在拆开来时，MVP与之并没有太大区别
    //

}
