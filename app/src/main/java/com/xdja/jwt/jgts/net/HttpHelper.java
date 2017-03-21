package com.xdja.jwt.jgts.net;

import android.text.TextUtils;

import com.gouhao.frame.base.LogUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private static HttpHelper ourInstance = new HttpHelper();

    private OkHttpClient okHttpClient;

    private ExecutorService threadPool;

    public static HttpHelper getInstance() {
        return ourInstance;
    }

    private HttpHelper() {
        okHttpClient = new OkHttpClient();
        threadPool = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
    }

    public void getAsync(final String url, final Map<String, String> header, final Map<String, String> data, final Callback callback) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                get(url, header, data, callback);
            }
        });
    }

    public void get(String url, Map<String, String> header, Map<String, String> data, Callback callback) {
        LogUtil.i(TAG, "url=" + url + ", header=" + header + ", data=" + data);
        if (url == null || TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url is null");
        }
        Request.Builder builder = new Request.Builder();
        addHeader(header, builder);

        if (data != null && !data.isEmpty()) {
            addGetData(url, data, builder);
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

    public void postAsync(final String url, final Map<String, String> header, final Map<String, String> data, final Callback callback) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                post(url, header, data, callback);
            }
        });
    }

    public void post(String url, Map<String, String> header, Map<String, String> data, Callback callback) {
        LogUtil.i(TAG, "url=" + url + ", header=" + header + ", data=" + data);
        if (url == null || TextUtils.isEmpty(url)) {
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
