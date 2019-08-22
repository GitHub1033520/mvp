package com.example.dell.mvp.presenter;

import com.example.dell.mvp.bean.MmBean;

import java.util.List;

public interface IPresenter {
    //定义给V层调用的接口
    void getChannel();

    //数据加载接口回调
    interface Callback{
        void  fail(String tips);
    void success(List<MmBean.DataBean.BrandListBean> rEsult);

}
}
