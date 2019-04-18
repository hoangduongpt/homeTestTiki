package com.kimduong.hometesttiki.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("/tikivn/android-home-test/v2/keywords.json")
    Observable<List<String>> getListKeyword();
}
