package com.example.dell.mvp.model;

import com.example.dell.mvp.api.MyServicer;
import com.example.dell.mvp.bean.MmBean;
import com.example.dell.mvp.presenter.IPresenter;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelImp implements  InModel {
    @Override
    public void mGetChannel(final IPresenter.Callback callback) {
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServicer.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //创建接口对象
        MyServicer myServicer = retrofit.create(MyServicer.class);

        //创建Call对象
        Call<MmBean> call = myServicer.getIndex();
        call.enqueue(new Callback<MmBean>() {
            @Override
            public void onResponse(Call<MmBean> call, Response<MmBean> response) {
                if (response.code()==0){
                    callback.success(response.body().getData().getBrandList());
                }else{
                    callback.fail(response.message());
                }
            }

            @Override
            public void onFailure(Call<MmBean> call, Throwable t) {
                callback.fail(t.getMessage());
            }
        });
    }
}
