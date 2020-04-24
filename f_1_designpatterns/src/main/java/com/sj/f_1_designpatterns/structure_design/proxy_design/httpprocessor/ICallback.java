package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

/**
 * Created by SJ on 2020/3/18.
 * 顶层回调接口
 * 隔离层接口回调
 */
public interface ICallback {

    /**
     * 三方框架 返回都可以是String
     * @param results
     */
    void onSuccess(String results);

    void onFailure(HttpError httpError);

}
