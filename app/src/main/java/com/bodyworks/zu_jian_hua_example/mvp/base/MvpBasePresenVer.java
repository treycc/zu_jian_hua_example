package com.bodyworks.zu_jian_hua_example.mvp.base;

/**
 * Created by treycc on 2017/3/27.
 */

public class MvpBasePresenVer<V> {

    V v;

    public MvpBasePresenVer(V v) {
        this.v = v;
    }

    public V getView() {
        return v;
    }
}
