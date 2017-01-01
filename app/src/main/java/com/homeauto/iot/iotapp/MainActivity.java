package com.homeauto.iot.iotapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.homeauto.iot.iotapp.presenter.MainPresenter;
import com.homeauto.iot.iotapp.presenter.impl.MainPresenterImpl;
import com.homeauto.iot.iotapp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    private Switch lightSwitch1;
    private Switch lightSwitch2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightSwitch1 = (Switch) findViewById(R.id.light_switch1);
        lightSwitch2 = (Switch) findViewById(R.id.light_switch2);
        presenter = new MainPresenterImpl(this);
        lightSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    presenter.turnOnLight1();
                } else {
                    presenter.turnOffLight1();
                }
            }
        });
        lightSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    presenter.turnOnLight2();
                } else {
                    presenter.turnOffLight2();
                }
            }
        });
    }

    @Override
    public void show(int msg) {

    }
}
