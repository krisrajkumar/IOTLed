package com.homeauto.iot.iotapp.presenter.impl;

import android.support.annotation.NonNull;

import com.homeauto.iot.iotapp.network.RequestListener;
import com.homeauto.iot.iotapp.network.RequestProvider;
import com.homeauto.iot.iotapp.presenter.MainPresenter;
import com.homeauto.iot.iotapp.util.IOTUtils;
import com.homeauto.iot.iotapp.view.MainView;

/**
 */

public class MainPresenterImpl implements MainPresenter, RequestListener {
    private MainView view;

    public MainPresenterImpl(@NonNull MainView view){
        this.view = view;
    }

    @Override
    public void turnOnLight1() {
        RequestProvider.getInstance().callLEDService(IOTUtils.DEVICE1, IOTUtils.STATE_ON, this);
    }

    @Override
    public void turnOffLight1() {
        RequestProvider.getInstance().callLEDService(IOTUtils.DEVICE1, IOTUtils.STATE_OFF, this);
    }

    @Override
    public void turnOnLight2() {
        RequestProvider.getInstance().callLEDService(IOTUtils.DEVICE2, IOTUtils.STATE_ON, this);
    }

    @Override
    public void turnOffLight2() {
        RequestProvider.getInstance().callLEDService(IOTUtils.DEVICE2, IOTUtils.STATE_OFF, this);
    }

    @Override
    public void onSuccess(String result) {

    }

    @Override
    public void onFailure(String result) {

    }
}
