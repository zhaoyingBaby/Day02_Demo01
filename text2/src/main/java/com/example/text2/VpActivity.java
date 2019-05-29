package com.example.text2;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class VpActivity extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        initView();
    }

    private static final String TAG = "VpActivity";
    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        ArrayList<User> user = getIntent().getParcelableArrayListExtra("user");
        Log.d(TAG, "initView: "+user.toString());
        views = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            User user1 = user.get(i);
            String imgurl = user1.getImgurl();
            View inflate = View.inflate(this, R.layout.viewpager, null);
            ImageView vp_img = inflate.findViewById(R.id.vp_img);
            Glide.with(this).load(imgurl).into(vp_img);
         views.add(inflate);
        }
        VpAdapter vpAdapter = new VpAdapter(views);
        mVp.setAdapter(vpAdapter);
    }
}
