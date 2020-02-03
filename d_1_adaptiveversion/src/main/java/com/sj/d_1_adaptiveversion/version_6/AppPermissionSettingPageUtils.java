package com.sj.d_1_adaptiveversion.version_6;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

import com.sj.commonres.utils.AndroidSystemUtils;

import static com.sj.commonres.utils.AndroidSystemUtils.HUA_WEI;
import static com.sj.commonres.utils.AndroidSystemUtils.SAMSUNG;
import static com.sj.commonres.utils.AndroidSystemUtils.XIAO_MI;

public class AppPermissionSettingPageUtils {


    public static void toPermissionSettingPage(Activity activity) {
        AndroidSystemUtils.logDeviceMsg();
        switch (AndroidSystemUtils.getBrand()) {
            case HUA_WEI:
                toEMUI(activity);
                break;
            case XIAO_MI:
                toMIUI(activity);
                break;
            case SAMSUNG:
                toSAUSUNG(activity);
                break;
            default:
                AndroidSystemUtils.toAppSetting(activity);
                break;
        }
    }

    private static void toEMUI(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");//华为权限管理
        intent.setComponent(comp);
        activity.startActivity(intent);
    }
    private static void toMIUI(Activity activity) {
        try { // MIUI 8
            Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            localIntent.putExtra("extra_pkgname", activity.getPackageName());
            activity.startActivity(localIntent);
        } catch (Exception e) {
            // MIUI 5/6/7
            Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            localIntent.putExtra("extra_pkgname", activity.getPackageName());
            activity.startActivity(localIntent);

        }
    }
    private static void toSAUSUNG(Activity activity) {

    }
}
