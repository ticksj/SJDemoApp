package com.sj.e_1_develop_construct.mvvm;

import android.view.View;

/**
 * Created by SJ on 2020/2/3.
 */
public class MVVMSimple {
    //双向绑定的MVP
    //提供一种框架
    //提供功能特性
    //MVC MVP 开发规范 MVVM强调功能特性

    public static class ViewModel {
        IDataObject dataObject = new IDataObject();

        public ViewModel(ViewBinder viewBinder, View view) {
            viewBinder.bind(view, dataObject);
        }

        public void load() {
            dataObject.setData("产生新数据");
        }


    }

    public static class IDataObject {
        Object data;
        IChangeListener changeListener;

        public void setChangeListener(IChangeListener changeListener) {
            this.changeListener = changeListener;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
            if (changeListener != null) {
                changeListener.changed(data);
            }
        }

        interface IChangeListener {
            void changed(Object data);
        }
    }


    public static class ViewBinder {
        //实现双向绑定
        void bind(final View v, final IDataObject dataObject) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dataObject.getData().toString().equals(v.getTag().toString())) {
                        return;
                    }
                    dataObject.setData(v.getTag().toString());
                }
            });
            dataObject.setChangeListener(new IDataObject.IChangeListener() {
                @Override
                public void changed(Object data) {
                    if (data.toString().equals(v.getTag().toString())) {
                        return;
                    }
                    v.setTag(dataObject.getData().toString());
                    v.performClick();
                }
            });
        }
    }


    public void use(){
    }
}
