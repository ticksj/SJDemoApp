package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

/**
 * Created by SJ on 2020/3/18.
 */
public class HttpError {
    String errorCode;
    String errorMsg;

    public HttpError(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
