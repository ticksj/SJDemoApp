package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

import java.util.Map;

/**
 * Created by SJ on 2020/3/18.
 */
public interface IHttpProcessor {

    void post(String url, Map<String,Object> params,ICallback callback);

    void get(String url, Map<String,Object> params,ICallback callback);
}
