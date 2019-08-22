package com.example.dell.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.dell.mvp.adapter.MyAdapter;
import com.example.dell.mvp.bean.MmBean;
import com.example.dell.mvp.model.ModelImp;
import com.example.dell.mvp.presenter.IPresenter;
import com.example.dell.mvp.presenter.Presenter;
import com.example.dell.mvp.view.InView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements InView {
private  IPresenter presenter;
    private RecyclerView mMainRecl;
    private ArrayList<MmBean.DataBean.BrandListBean> listBeans;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMap();
    }

    private void initMap() {
          presenter =  new Presenter(this,new ModelImp());
          presenter.getChannel();
    }

    private void initView() {
        mMainRecl = (RecyclerView) findViewById(R.id.main_recl);
        //创建布局管理器
        mMainRecl.setLayoutManager(new GridLayoutManager(this,2));
        //创建集合
        listBeans = new ArrayList<>();
        //创建适配器
        myAdapter = new MyAdapter(this, listBeans);
        //绑定适配器
        mMainRecl.setAdapter(myAdapter);


    }

    @Override
    public void showChannel(List<MmBean.DataBean.BrandListBean> brandListBeans) {
       listBeans.addAll(brandListBeans);
       myAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTips(String tips) {
        Toast.makeText(this, tips, Toast.LENGTH_SHORT).show();
    }
}
