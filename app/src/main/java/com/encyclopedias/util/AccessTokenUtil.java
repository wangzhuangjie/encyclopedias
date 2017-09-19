package com.encyclopedias.util;

import android.content.Intent;
import android.text.TextUtils;

import com.encyclopedias.FEApplication;
import com.encyclopedias.data.local.PreferencesHelper;
import com.encyclopedias.data.model.SessionToken;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by baiyuliang on 2016-7-8.
 */
public class AccessTokenUtil {



    public static String getAccessToken() {
        PreferencesHelper preferencesHelper = new PreferencesHelper(FEApplication.getInstance().getApplicationContext());
        if(TextUtils.isEmpty(preferencesHelper.getString(ConstantPool.PREF_ACCESS_TOKEN))){
            return null;
        }
        String newAccesssToken = null;
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(10 * 1000, TimeUnit.MILLISECONDS);//设置请求超时时间10s
        OkHttpClient okHttpClient = okHttpClientBuilder.build();
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        String refresh_token=preferencesHelper.getString(ConstantPool.PREF_REFRESH_TOKEN);
        if(TextUtils.isEmpty(refresh_token)){
            return null;
        }
        bodyBuilder.add("refresh_token",refresh_token);
        Request request = new Request.Builder().url("").post(bodyBuilder.build()).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            String result = response.body().string();
            Gson gson = new Gson();
            SessionToken sessionToken = gson.fromJson(result, SessionToken.class);
            newAccesssToken = sessionToken.getAccess_token();
            if (!TextUtils.isEmpty(newAccesssToken)) {
                preferencesHelper.putString(ConstantPool.PREF_ACCESS_TOKEN, sessionToken.getAccess_token());
            } else {//refreshToken失效，跳转至登录界面
                FEApplication.getInstance().sendBroadcast(new Intent(ConstantPool.ACTION_RELOGIN));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newAccesssToken;
    }

}
