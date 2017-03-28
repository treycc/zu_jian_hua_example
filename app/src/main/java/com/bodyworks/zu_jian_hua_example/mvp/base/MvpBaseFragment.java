package com.bodyworks.zu_jian_hua_example.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by treycc on 2017/3/28.
 */

public abstract class MvpBaseFragment<V, P extends MvpBasePresenter<V>> extends Fragment implements IBaseDelegate<V, P> {

    P p;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = createPresenter();
    }

    @Override
    public P getPresenter() {
        return p;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (p != null) {
            p.detachView();
        }
    }
}
