package com.example.dell.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.mvp.R;
import com.example.dell.mvp.bean.MmBean;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<MmBean.DataBean.BrandListBean> listBeans;

    public MyAdapter(Context context, ArrayList<MmBean.DataBean.BrandListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_mv_item,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder myHolder = (MyHolder) viewHolder;
        Glide.with(context).load(listBeans.get(i).getNew_pic_url()).into(myHolder.img);
        myHolder.tv_title.setText(listBeans.get(i).getName());
        myHolder.tv_price.setText(listBeans.get(i).getFloor_price());

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final TextView tv_title;
        private final TextView tv_price;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_price = itemView.findViewById(R.id.tv_price);

        }
    }
}
