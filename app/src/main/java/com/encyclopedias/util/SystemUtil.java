package com.encyclopedias.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

import com.encyclopedias.FEApplication;


/**
 * Created by Frank on 2016/7/1.
 */
public class SystemUtil {

    public static String getAppVersion() {
        Context context = FEApplication.getInstance();
        PackageManager manager = context.getPackageManager();

        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "UNKNOWN";
        }
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;
        String phrase = "";
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase += Character.toUpperCase(c);
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase += c;
        }
        return phrase;
    }

    public static boolean getPermissionsGranted(Context context, String permission) {
        int check = context.checkCallingOrSelfPermission(permission);
        boolean permissionsGranted = (check == PackageManager.PERMISSION_GRANTED);
        return permissionsGranted;
    }

    public static String getSecrect(){
        return "de6c3cb9967a0691339cdf615422f94c";
    }

    public static String getClientId() {
        return "androidDriver";
    }
}
