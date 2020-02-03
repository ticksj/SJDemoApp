package com.sj.commonres.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by SJ on 2020/1/19.
 */
public class AndroidSystemUtils {
    private static final String TAG = "AndroidSystemUtils";


    public static final String HUA_WEI = "huawei";
    public static final String XIAO_MI = "xiaomi";
    public static final String SAMSUNG = "sumsung";


//    android手机信息可以通过android.os.Build类中提取设备硬件和系统版本信息，

    String MANUFACTURER = android.os.Build.MANUFACTURER; //硬件制造商
    String BRAND = android.os.Build.BRAND; //手机品牌
    String DEVICE = android.os.Build.DEVICE; //设备名
    String MODEL = android.os.Build.MODEL; //用户可见的手机型号
    String DISPLAY = android.os.Build.DISPLAY; //显示屏参数
    String PRODUCT = android.os.Build.PRODUCT; //产品名称（手机厂商）
    String FINGERPRINT = android.os.Build.FINGERPRINT;//设备唯一识别码
    String CPU_ABI = android.os.Build.CPU_ABI;//CPU的指令集
    String CPU_ABI2 = android.os.Build.CPU_ABI2;//CPU的指令集2
    String ID = android.os.Build.ID;//修订版本列表
    String TAGS = android.os.Build.TAGS;//描述Build的标签

    public static void logDeviceMsg(){
        Log.e(TAG, "logDeviceMsg: "+"\n"
                      +"硬件制造商: android.os.Build.MANUFACTURER=="+android.os.Build.MANUFACTURER +"\n"
                      +"手机品牌: android.os.Build.BRAND=="+android.os.Build.BRAND +"\n"
                      +"设备名: android.os.Build.DEVICE=="+android.os.Build.DEVICE +"\n"
                      +"用户可见的手机型号: android.os.Build.MODEL=="+android.os.Build.MODEL +"\n"
                      +"显示屏参数: android.os.Build.DISPLAY=="+android.os.Build.DISPLAY +"\n"
                      +"厂商）: android.os.Build.PRODUCT=="+android.os.Build.PRODUCT +"\n"
                      +"设备唯一识别码: android.os.Build.FINGERPRINT=="+android.os.Build.FINGERPRINT +"\n"
                      +"CPU的指令集: android.os.Build.CPU_ABI=="+android.os.Build.CPU_ABI +"\n"
                      +"CPU的指令集2: android.os.Build.CPU_ABI2=="+android.os.Build.CPU_ABI2 +"\n"
                      +"修订版本列表: android.os.Build.ID=="+android.os.Build.ID +"\n"
                      +"描述Build的标签: android.os.Build.TAGS=="+android.os.Build.TAGS);
    }

    public static String getBrand() {
        if (android.os.Build.BRAND.toLowerCase().contains(HUA_WEI.toLowerCase())) {
            return HUA_WEI;
        }
        if (android.os.Build.BRAND.toLowerCase().contains(XIAO_MI.toLowerCase())) {
            return XIAO_MI;
        }
        if (android.os.Build.BRAND.toLowerCase().contains(SAMSUNG.toLowerCase())) {
            return SAMSUNG;
        }
        return "";
    }

    /**
     * 跳转系统设置页面
     * @param activity
     */
    public static void toSystemSetting(Activity activity){
        activity.startActivity(new Intent(Settings.ACTION_SETTINGS));
    }
    /**
     * 跳转App详情设置页面
     * @param activity
     */
    public static void toAppSetting(Activity activity){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        activity.startActivity(intent);
    }




}
