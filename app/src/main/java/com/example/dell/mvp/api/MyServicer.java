package com.example.dell.mvp.api;

import com.example.dell.mvp.bean.MmBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MyServicer {
    String base_url = "https://cdwan.cn/";
    @GET("index")
    Call<MmBean>getIndex();
}
