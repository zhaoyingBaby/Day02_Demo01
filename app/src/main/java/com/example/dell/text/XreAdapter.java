package com.example.dell.text;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * Created by DELL on 2019/5/29.
 */

public class XreAdapter extends XRecyclerView.Adapter {

    private Context context;
    private ArrayList<UserBean>mlist;

    public XreAdapter(Context context, ArrayList<UserBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null, false);
        return new XreViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    XreViewHolder xreViewHolder= (XreViewHolder) holder;
        UserBean userBean = mlist.get(position);
        Glide.with(context).load(userBean.getImgurl()).into(xreViewHolder.item_img);
        xreViewHolder.item_tv.setText(userBean.getDesc());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    class XreViewHolder extends XRecyclerView.ViewHolder {
        private ImageView item_img;
        private TextView item_tv;
        public XreViewHolder(View itemView) {
            super(itemView);
            item_img=itemView.findViewById(R.id.item_img);
            item_tv=itemView.findViewById(R.id.item_tv);
        }
    }
}
