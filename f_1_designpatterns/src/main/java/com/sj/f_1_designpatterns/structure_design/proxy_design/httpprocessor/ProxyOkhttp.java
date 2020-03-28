package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by SJ on 2020/3/18.
 * 被代理的访问框架
 */
public class ProxyOkhttp implements IHttpProcessor{
    private OkHttpClient  okHttpClient;
    private Handler myHandler;

    public ProxyOkhttp() {
        okHttpClient = new OkHttpClient();
        myHandler = new Handler();

    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
       final RequestBody requestBody = appendBody(params);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                if (response.isSuccessful()) {
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(result);
                        }
                    });
                }else {
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(new HttpError("error","error"));
                        }
                    });
                }
            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                if (response.isSuccessful()) {
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(result);
                        }
                    });
                }else {
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(new HttpError("error","error"));
                        }
                    });
                }
            }
        });
    }

    private RequestBody appendBody(Map<String, Object> params) {
        // TODO: 2020/3/22 待修改
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            builder.add(entry.getKey(), (String) entry.getValue());
        }
        return builder.build();
    }
}
