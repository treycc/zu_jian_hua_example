package com.bodyworks.zu_jian_hua_example.mvp.presenter;


import android.os.Handler;

import com.bodyworks.zu_jian_hua_example.mvp.base.MvpBasePresenVer;
import com.bodyworks.zu_jian_hua_example.mvp.view.MainView;

/**
 * Created by treycc on 2017/3/27.
 */

public class MainPresenter extends MvpBasePresenVer<MainView> {

    public MainPresenter(MainView mainView) {
        super(mainView);
    }

    public void request(final String name) {
        getView().showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().hideProgress();
                getView().loadDataComplate(name);
            }
        }, 2000);
    }

    public void change() {
        getView().showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().hideProgress();
                getView().changeName("你还好吗");
            }
        }, 2000);

    }
}
