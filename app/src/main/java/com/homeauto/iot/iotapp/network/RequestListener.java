package com.homeauto.iot.iotapp.network;

/**
 */

public interface RequestListener {
    void onSuccess(String result);
    void onFailure(String result);
}
