package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by SJ on 2020/3/18.
 * 回调接口的一种实现
 * 将返回的json字符串转换成参数化类型
 */
public abstract class HttpCallback<Result> implements ICallback {
    private static final String TAG = "HttpCallback";
    @Override
    public void onSuccess(String results) {
//        得到调用者用什么样的javabean来接收数据
        Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);
        Result result = (Result) gson.fromJson(results, clz);
//        将结果交给用户
        onSuccess(result);
    }

    protected abstract void onSuccess(Result result);


    private Class<?> analysisClassInfo(Object object) {
//        getClass().getGenericSuperclass() 返回一个类型对象 可以得到原始类型、参数化、数组、类型变量、基本数据类型
        Type genType = object.getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) types[0];
    }

    @Override
    public void onFailure(HttpError httpError) {
        Log.e(TAG, "onFailure: "+httpError.errorMsg );
    }
}
