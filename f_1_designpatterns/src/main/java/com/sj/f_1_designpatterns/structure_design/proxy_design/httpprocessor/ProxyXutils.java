package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

import com.sj.f_1_designpatterns.MyApplication;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by SJ on 2020/3/18.
 * 被代理的访问框架
 */
public class ProxyXutils implements IHttpProcessor{


    public ProxyXutils() {
        x.Ext.init(MyApplication.getInstance());
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        x.http().post(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
