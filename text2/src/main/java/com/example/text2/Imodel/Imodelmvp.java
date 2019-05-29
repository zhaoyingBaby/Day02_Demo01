package com.example.text2.Imodel;

import android.util.Log;

import com.example.text2.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by DELL on 2019/5/29.
 */

public class Imodelmvp implements Imodel {
    private static final String TAG = "Imodelmvp";
    @Override
    public void getmodel(final CallBack callBack) {
    String url="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resut = response.body().string();
                Log.d(TAG, "onResponse: "+resut);
                try {
                    JSONObject jsonObject = new JSONObject(resut);
                    JSONArray results = jsonObject.getJSONArray("results");
                    ArrayList<User> users = new ArrayList<>();
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject jsonObject1 = results.getJSONObject(i);
                        String desc = jsonObject1.optString("desc");
                        String url = jsonObject1.optString("url");
                        User user = new User();
                        user.setImgurl(url);
                        user.setDesc(desc);
                        users.add(user);
                    }
                    callBack.getresult(users);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
