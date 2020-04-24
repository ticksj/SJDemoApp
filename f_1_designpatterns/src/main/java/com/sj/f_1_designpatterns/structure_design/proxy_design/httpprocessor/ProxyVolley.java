package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Created by SJ on 2020/3/18.
 * 被代理的访问框架
 */
public class ProxyVolley implements IHttpProcessor{


    private static RequestQueue requestQueue = null;

    public ProxyVolley(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(new HttpError("Volley",error.getMessage()));
            }
        });
        requestQueue.add(request);
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(new HttpError("Volley",error.getMessage()));
            }
        });
        requestQueue.add(request);
    }
}
