package com.sj.g_1_jetpack.viewmodel_livedata;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by SJ on 2020/4/27.
 * livedata 感应数据变化，
 * DataBinding  去掉activity严重依赖布局
 */
public class PhoneViewModel extends AndroidViewModel {
    private static final String TAG = "PhoneViewModel";



    private MutableLiveData<String> phoneInfo;

    private Context context;

    public PhoneViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    // 我的UI数据 是什么 ？
    // 传统方式的 数据
    // private String phoneInfo = ""; 无法做到感应

    // 暴露数据  UI 数据
    public MutableLiveData<String> getPhoneInfo() {
        if (phoneInfo == null) {
            phoneInfo = new MutableLiveData<>();
            // 默认值
            phoneInfo.setValue("");
        }
        return phoneInfo;
    }

    /**
     * 输入
     * @param number
     */
    public void appendNumber(String number) {
        phoneInfo.setValue(phoneInfo.getValue() + number);;
    }

    /**
     * 删除
     */
    public void backspaceNumber() {
        int length = phoneInfo.getValue().length();
        if (length > 0) {
            phoneInfo.setValue(phoneInfo.getValue().substring(0, phoneInfo.getValue().length() - 1));
        }
    }

    /**
     * 清空
     */
    public void clear() {
        phoneInfo.setValue("");;
    }

    // 要有环境 Context
    public void  callPhone() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneInfo.getValue()));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


}
