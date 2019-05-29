package com.example.dell.text.Imodel;

import android.util.Log;

import com.example.dell.text.ApiService;
import com.example.dell.text.UserBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2019/5/29.
 */

public class Modelmvp implements Imodel {
    private static final String TAG = "Modelmvp";
    @Override
    public void getmodel(final CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        apiService.geturl().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {

                            String results = responseBody.string();
                            Log.d(TAG, "onNext: 数据" + results);
                            JSONObject jsonObject = new JSONObject(results);
                            JSONArray array = jsonObject.getJSONArray("T1348654060988");
                            ArrayList<UserBean> userBeans = new ArrayList<>();
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jsonObject1 = array.getJSONObject(i);
                                String imgsrc = jsonObject1.optString("imgsrc");
                                String digest = jsonObject1.optString("digest");
                                UserBean userBean = new UserBean();
                                userBean.setDesc(digest);
                                userBean.setImgurl(imgsrc);
                                userBeans.add(userBean);
                            }
                            callBack.getsuccess(userBeans);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
