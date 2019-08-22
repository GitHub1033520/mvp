package com.example.dell.mvp.presenter;

import com.example.dell.mvp.bean.MmBean;
import com.example.dell.mvp.model.InModel;
import com.example.dell.mvp.model.ModelImp;
import com.example.dell.mvp.view.InView;

import java.util.List;

public class Presenter implements IPresenter,IPresenter.Callback {
    private InView view;
    private InModel model;

    public Presenter(InView view, InModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getChannel() {
        model.mGetChannel(this);
    }
    //获取到m层数据加载失败的回调
    @Override
    public void fail(String tips) {
        if (view!=null){
            view.showTips(tips);
        }
    }
    //获取到m层数据加载的成功的数据
    @Override
    public void success(List<MmBean.DataBean.BrandListBean> rEsult) {
        if (view!=null){
            view.showChannel(rEsult);
        }
    }
}
