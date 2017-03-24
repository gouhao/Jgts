package com.xdja.jwt.jgts.net;

import android.text.TextUtils;

import com.gouhao.frame.utils.LogUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by gouhao on 3/21/2017.
 */
public class HttpHelper {
    private static String TAG = "HttpHelper";

    private static final int MAX_THREAD_COUNT = 3;
    private static final long DEFAULT_TIME_OUT = 20;
    private static HttpHelper ourInstance = new HttpHelper();

    private OkHttpClient okHttpClient;

    public static HttpHelper getInstance() {
        return ourInstance;
    }

    private HttpHelper() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    public void get(String url, Map<String, String> header, Map<String, String> data, Callback callback) {
        LogUtil.i(TAG, "url=" + url + ", header=" + header + ", data=" + data);
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url is null");
        }
        Request.Builder builder = new Request.Builder();
        if(header != null) {
            addHeader(header, builder);
        }

        if (data != null && !data.isEmpty()) {
            addGetData(url, data, builder);
        } else {
            builder.url(url);
        }

        Request request = builder.build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    private void addGetData(String url, Map<String, String> data, Request.Builder builder) {
        StringBuilder sb = new StringBuilder(url + "?");
        Iterator<String> dataIterator = data.keySet().iterator();
        while (dataIterator.hasNext()) {
            String key = dataIterator.next();
            String value = data.get(key);
            sb.append(key + '=' + value + '&');
        }
        sb.deleteCharAt(sb.length() - 1);
        builder.url(sb.toString());
    }

    public void post(String url, Map<String, String> header, Map<String, String> data, Callback callback) {
        LogUtil.i(TAG, "url=" + url + ", header=" + header + ", data=" + data);
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url is null");
        }
        Request.Builder builder = new Request.Builder();
        builder.url(url);

        if (header != null && !header.isEmpty()) {
            addHeader(header, builder);
        }

        if (data != null && !data.isEmpty()) {
            addPostData(data, builder);
        }
        okHttpClient.newCall(builder.build()).enqueue(callback);
    }

    private void addPostData(Map<String, String> data, Request.Builder builder) {
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        Iterator<String> dataIterator = data.keySet().iterator();
        while (dataIterator.hasNext()) {
            String key = dataIterator.next();
            String value = data.get(key);
            bodyBuilder.add(key, value);
        }
        builder.post(bodyBuilder.build());
    }

    private void addHeader(Map<String, String> header, Request.Builder builder) {
        Iterator<String> headerIterator = header.keySet().iterator();
        while (headerIterator.hasNext()) {
            String key = headerIterator.next();
            String value = header.get(key);
            builder.header(key, value);
        }
    }
}
