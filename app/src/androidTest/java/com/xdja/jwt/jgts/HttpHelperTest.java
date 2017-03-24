package com.xdja.jwt.jgts;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.gouhao.frame.utils.LogUtil;
import com.xdja.jwt.jgts.module.main.MainActivity;
import com.xdja.jwt.jgts.net.HttpHelper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by gouhao on 3/21/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HttpHelperTest {
    private static final String TAG = "HttpHelperTest: ";
    private static final String TEST_URL = "https://www.baidu.com";
    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testGet(){
        HttpHelper.getInstance().get(TEST_URL, null, null, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                LogUtil.i(TAG, body.string());
                if(response.isSuccessful()) {
                    LogUtil.i(TAG, "get success");
                }
            }
        });
    }

    @Test
    public void testPost(){
        HttpHelper.getInstance().post(TEST_URL, null, null, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                LogUtil.i(TAG, body.string());
                if(response.isSuccessful()) {
                    LogUtil.i(TAG, "get success");
                }
            }
        });
    }
}
