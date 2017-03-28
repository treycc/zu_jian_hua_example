package com.bodyworks.zu_jian_hua_example.mvp.base;

/**
 * Created by treycc on 2017/3/28.
 */

public class MvpBaseModel<P extends MvpBasePresenter> {

    P p;

    public MvpBaseModel(P p) {
        this.p = p;
    }

    public P getPresenter() {
        return p;
    }

}
