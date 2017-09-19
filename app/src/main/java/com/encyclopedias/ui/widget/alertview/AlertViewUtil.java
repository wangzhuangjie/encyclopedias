package com.encyclopedias.ui.widget.alertview;

import android.content.Context;

/**
 * Created by baiyuliang on 2016-7-4.
 */
public class AlertViewUtil {

    /**
     * 普通信息使用
     * @param context
     * @param title
     * @param msg
     * @param cancel
     * @param ok
     * @param onItemClickListener
     */
    public static void show(Context context, String title, String msg, String cancel, String ok, com.encyclopedias.ui.widget.alertview.OnItemClickListener onItemClickListener) {
        new AlertView(title, msg, cancel, new String[]{ok}, null, context, AlertView.Style.Alert, onItemClickListener).show();
    }

    /**
     * 强制更新使用
     * @param context
     * @param title
     * @param msg
     * @param ok
     * @param onItemClickListener
     */
    public static void show(Context context, String title, String msg, String ok, com.encyclopedias.ui.widget.alertview.OnItemClickListener onItemClickListener) {
        new AlertView(title, msg, null, new String[]{ok}, null, context, AlertView.Style.Alert, onItemClickListener).setCancelable(false).setCanDismiss(false).show();
    }

    /**
     * 问诊信息通知使用
     * @param context
     * @param title
     * @param msg
     * @param onItemClickListener
     */
    public static void show(Context context, String title, String msg, com.encyclopedias.ui.widget.alertview.OnItemClickListener onItemClickListener) {
        new AlertView(title, msg, "稍后再说", new String[]{"现在进入"}, null, context, AlertView.Style.Alert, onItemClickListener).setCancelable(false).show();
    }


    

}
