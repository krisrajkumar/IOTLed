package com.homeauto.iot.iotapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("/led")
    Call<String> updateLEDState(@Query("device") String device, @Query("status") String state);
}
