package com.example.dell.text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.dell.text.Ipersnenter.Persentermvp;
import com.example.dell.text.Iview.Iview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview{

    private XRecyclerView mXre;
    private ArrayList<UserBean> list;
    private XreAdapter xreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mXre = (XRecyclerView) findViewById(R.id.xre);
        mXre.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        xreAdapter = new XreAdapter(this, list);
        mXre.setAdapter(xreAdapter);
        Persentermvp persentermvp = new Persentermvp(this);
        persentermvp.getpersenter();
    }

    @Override
    public void getresult(List<UserBean> result) {
    list.addAll(result);
    xreAdapter.notifyDataSetChanged();
    }
}
