package com.huruwo.restfulapp.okhttp;

import com.huruwo.restfulapp.api.ApiConstants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * AUTHOR: zyb
 * DATE: 17/5/9.
 * ACTION:头部添加拦截器
 */

public class HeaderInterceptor implements Interceptor {



    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request()
                .newBuilder()
                .addHeader("token", ApiConstants.TOKEN)
                .build();
        //return chain.proceed(addParam(request));
        return chain.proceed(request);
    }

    /**
     * 添加公共参数
     *
     * @param oldRequest
     * @return
     */
    private Request addParam(Request oldRequest) {
        HttpUrl.Builder builder = oldRequest.url()
                .newBuilder()
                /**
                 * 不能 防止伪造时间戳
                 */
                .setEncodedQueryParameter("timestamp", System.currentTimeMillis()+"");
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(builder.build())
                .build();
        return newRequest;
    }
}
