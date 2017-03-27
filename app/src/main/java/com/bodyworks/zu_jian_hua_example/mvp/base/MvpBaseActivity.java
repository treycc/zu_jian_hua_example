package com.bodyworks.zu_jian_hua_example.mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by treycc on 2017/3/27.
 */

public abstract class MvpBaseActivity<V, P> extends AppCompatActivity {

    P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = createPresenter();
    }

    @NonNull
    public abstract P createPresenter();

    public P getPresenter() {
        return p;
    }

}
