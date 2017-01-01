package com.homeauto.iot.iotapp.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestProvider {
    private static RequestProvider instance;

    private RequestProvider() {
    }

    public static RequestProvider getInstance() {
        if (instance == null) {
            instance = new RequestProvider();
        }
        return instance;
    }

    public void callLEDService(final String device, final String state, final RequestListener requestListener) {
        APIService apiService = ServiceGenerator.createService(APIService.class);
        Call<String> call = apiService.updateLEDState(device, state);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                requestListener.onSuccess(response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                requestListener.onSuccess(t.getMessage());
            }
        });
    }
}
