package com.example.text2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.text2.Ipersenter.Persentermvp;
import com.example.text2.Iview.Iview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview{

    private XRecyclerView mXrecycler;
    private ArrayList<User> list;
    private XreAdapter xreAdapter;
    private Persentermvp persentermvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mXrecycler = (XRecyclerView) findViewById(R.id.xrecycler);
        mXrecycler.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        xreAdapter = new XreAdapter(this, list);
        mXrecycler.setAdapter(xreAdapter);
        persentermvp = new Persentermvp(this);
        persentermvp.getpersenter();
        xreAdapter.setOnclickListener(new XreAdapter.OnclickListener() {
            @Override
            public void ClickItem(int position) {
                User user = list.get(position);
                Intent intent = new Intent(MainActivity.this, VpActivity.class);
                intent.putParcelableArrayListExtra("user", (ArrayList<User>)list);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getresultsuccess(List<User> result) {
        list.addAll(result);
        xreAdapter.notifyDataSetChanged();
    }
}
