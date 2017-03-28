package com.bodyworks.zu_jian_hua_example.mvp.base;

/**
 * Created by treycc on 2017/3/27.
 */

public class MvpBasePresenter<V> {

    V v;

    public MvpBasePresenter(V v) {
        this.v = v;
    }

    public V getView() {
        return v;
    }

    public void detachView(){

    }
}
