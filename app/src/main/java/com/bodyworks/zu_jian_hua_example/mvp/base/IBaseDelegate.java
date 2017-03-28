package com.bodyworks.zu_jian_hua_example.mvp.base;

import android.support.annotation.NonNull;

/**
 * Created by treycc on 2017/3/28.
 */

public interface IBaseDelegate<V, P extends MvpBasePresenter<V>> {

    @NonNull
    P createPresenter();

    P getPresenter();

}
