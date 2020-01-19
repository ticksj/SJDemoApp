package com.sj.d_1_adaptiveversion.version_6;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

public class PermissionActivity extends AppCompatActivity {

    private int permissionResultCode = 1;
    private PermissionCallback permissionCallback;

    /**
     * 权限申请入口
     * @param permission 权限名
     * @param permissionReason 获取理由
     * @param permissionCallback 结果回调
     */
    public void requestPermission(final String permission, String permissionReason, PermissionCallback permissionCallback) {
        this.permissionCallback=permissionCallback;
        if (!hasPermission(permission)) {
            if (needExplainPermissionReason(permission)) {
                new AlertDialog.Builder(this)
                        .setTitle("")
                        .setMessage(permissionReason)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestPermission(permission);
                            }
                        })
                        .show();
            } else {
                requestPermission(permission);
            }
        }else {
            if (this.permissionCallback != null) {
                this.permissionCallback.granted();
            }
        }
    }

    /**
     * 申请权限的有无状态
     * @param permission
     * @return
     */
    private boolean hasPermission(String permission) {
        int targetSdkVersion = getApplicationInfo().targetSdkVersion;
        if (targetSdkVersion >= Build.VERSION_CODES.M) {
            return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
        } else {
            return PermissionChecker.checkSelfPermission(this, permission) == PermissionChecker.PERMISSION_GRANTED;
        }
    }

    /**
     * 是否需要解释该权限
     * 权限需要解释的条件：上一次请求被拒绝，且没有点击不再询问
     * @param permission
     * @return true 需要解释后再次进行询问；false：不需询问有两种情况 用户禁止询问了，从未询问过
     */
    private boolean needExplainPermissionReason(String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
    }

    /**
     * 申请权限
     * @param permission
     */
    private void requestPermission(String permission) {
        ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{permission}, permissionResultCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull final String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == permissionResultCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //权限通过
            } else {
                if (!needExplainPermissionReason(Manifest.permission.CAMERA)) {
                    //解释理由 跳转去应用信息页设置
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("主动询问已被禁止，需要到应用权限配置页面主动授予是否允许？")
                            .setPositiveButton("跳转", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    toAppPermissionSet();
                                    if (permissionCallback != null) {
                                        permissionCallback.waitUserInitiativeSet();
                                    }
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    if (permissionCallback != null) {
                                        permissionCallback.denied();
                                    }
                                }
                            })
                            .show();
                }
            }
            return;
        }
    }

    /**
     * 跳转应用权限配置页面
     */
    private void toAppPermissionSet() {
        AppPermissionSettingPageUtils.toPermissionSettingPage(this);
    }

    public interface PermissionCallback{
        /**
         * 获取权限成功
         */
        void granted();

        /**
         * 获取权限失败
         */
        void denied();

        /**
         * 用户跳转配置页配置中
         */
        void waitUserInitiativeSet();
    }
}
