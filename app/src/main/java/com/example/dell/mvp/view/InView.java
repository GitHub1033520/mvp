package com.example.dell.mvp.view;

import com.example.dell.mvp.bean.MmBean;

import java.util.List;

public interface InView {

    //给p层获取数据展示
    void showChannel(List<MmBean.DataBean.BrandListBean> brandListBeans);

    //数据
    void showTips(String tips);
}
