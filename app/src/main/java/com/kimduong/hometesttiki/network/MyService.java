package com.kimduong.hometesttiki.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyService {
    private RequestInterface requestInterface;
    private static MyService INSTANCE;
    private static final String BASE_URL = "https://raw.githubusercontent.com";

    private MyService() {
         requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface.class);
    }

    public static MyService getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new MyService();
        }
        return INSTANCE;
    }

    public RequestInterface getRequestInterface() {
        return requestInterface;
    }
}
