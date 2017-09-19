package com.encyclopedias.data.remote;

import android.text.TextUtils;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.encyclopedias.FEApplication;
import com.encyclopedias.ui.user.UserEntity;
import com.encyclopedias.util.AccessTokenUtil;
import com.encyclopedias.util.FETextUtils;
import com.encyclopedias.util.MDUtil;
import com.encyclopedias.util.RxErrorHandlingCallAdapterFactory;
import com.encyclopedias.util.SystemUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;


public interface APIService {

    String ENDPOINT = "http://www.";

    // 全部医院
    @GET
    Observable<UserEntity> getcity(@Url String url, @Query("cityname") String cityname, @Query("key") String key);

    /********
     * Helper class that sets up a new services
     *******/
    class Creator {
        public static APIService newRibotsService() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request request = chain.request();
//                        FEApplication.getInstance().getComponent().
                        HttpUrl ourl = request.url();
                        HttpUrl url = null;
                            StringBuilder osign = new StringBuilder();
                            List<String> pathSegs = ourl.encodedPathSegments();
                            if (pathSegs != null && pathSegs.size() > 0) {
                                for(String ps : pathSegs){
                                    if (TextUtils.isDigitsOnly(ps)) {
                                        osign.append(ps);
                                    }
                                }

                            }
                            Set<String> urls = ourl.queryParameterNames();
                            Observable.from(urls).filter(name -> !"access_token".equals(name)).forEach(name -> osign.append(ourl.queryParameter(name)));

                        if (request.method().equals("GET")||request.method().equals("DELETE")) {
//                            osign.append(SystemUtil.getSecrect());   // TODO 替换成SIGN
                            String sign = MDUtil.getMD5(osign.toString());
                            url = ourl.newBuilder().build();
                            request = request.newBuilder().url(url).build();
                        } else if(request.body().contentType()==null || request.body().contentType().toString().contains("x-www-form-urlencoded")){
                            Request.Builder requestBuilder = request.newBuilder();
                            String postBodyString = FETextUtils.bodyToString(request.body());
                            String sign = FETextUtils.signRequestBody(postBodyString, SystemUtil.getSecrect());
                            RequestBody formBody = new FormBody.Builder().add("sign",sign).build();
                            postBodyString += ((postBodyString.length() > 0) ? "&" : "") +  FETextUtils.bodyToString(formBody);
                            if (request.method().equals("POST")) {
                                request = requestBuilder
                                        .post(RequestBody.create(request.body().contentType(), postBodyString))
                                        .build();
                            }else{  // TODO 检查是否有其他方式
                                request = requestBuilder
                                        .put(RequestBody.create(request.body().contentType(), postBodyString))
                                        .build();
                            }
//                            url = ourl.newBuilder().addQueryParameter("test-request", "f4252835efdf076bfabf17e41fb498dd").build();
                        }
                        Response response = chain.proceed(request);
                        return response;
                    })
                    .addInterceptor((chain) -> {//log拦截器
                        Request request = chain.request();
                        Log.e("request>>" ,""+ request.toString());
                        Response response = chain.proceed(chain.request());
                        MediaType mediaType = response.body().contentType();
                        String content = response.body().string();
                        Log.e("response>>","" + content);
                        return response.newBuilder().body(ResponseBody.create(mediaType, content)).build();
                    })
                    .authenticator((route, response) -> {//token失效拦截
                        String newAccessToken = AccessTokenUtil.getAccessToken();
                        if (!TextUtils.isEmpty(newAccessToken)) {
                            Request request = response.request();
                            HttpUrl url = request.url()
                                    .newBuilder()
                                    .removeAllQueryParameters("access_token")
                                    .addQueryParameter("access_token", newAccessToken)
                                    .build();
                            return request.newBuilder().url(url).build();
                        } else {
                            return null;
                        }
                    })
                    .hostnameVerifier((hostname, session) -> true).build();

            Glide.get(FEApplication.getInstance()).register(GlideUrl.class, InputStream.class,
                    new OkHttpUrlLoader.Factory(client));
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIService.ENDPOINT)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(APIService.class);
        }
    }
}
