package com.example.dell.mvp.model;

import com.example.dell.mvp.presenter.IPresenter;

public interface InModel {
    //定义一个接口给p层调用接口
    void mGetChannel(IPresenter.Callback callback);
}
