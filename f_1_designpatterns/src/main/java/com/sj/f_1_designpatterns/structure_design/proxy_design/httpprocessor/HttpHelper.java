package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by SJ on 2020/3/18.
 * 具体的操作代理对象
 */
public class HttpHelper implements IHttpProcessor {


    private static HttpHelper httpHelper = new HttpHelper();

    private HttpHelper() {
    }
    // 被代理的对象
    private static IHttpProcessor httpProcessor = null;

    public static void init(IHttpProcessor processor){
        httpProcessor = processor;
    }

    public static HttpHelper getHttpHelper() {
        return httpHelper;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        String finalUrl = appendParams(url, params);
        httpProcessor.post(finalUrl, params, callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        httpProcessor.get(url, params, callback);
    }


    public static String appendParams(String url,Map<String, Object> params){
        if (params == null||params.isEmpty()) {
            return url;
        }
        StringBuilder urlBuilder = new StringBuilder(url);
        if (urlBuilder.indexOf("?")<=0) {
            urlBuilder.append("?");
        }else {
            if (!urlBuilder.toString().endsWith("?")) {
                urlBuilder.append("&");
            }
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            urlBuilder.append("&"+entry.getKey())
                    .append("=")
                    .append(encode(entry.getValue().toString()));
        }
        return urlBuilder.toString();
    }

    private static String encode(String string) {
        try {
            return URLEncoder.encode(string,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
