package com.bodyworks.zu_jian_hua_example.mvp.model;

import com.bodyworks.zu_jian_hua_example.mvp.base.MvpBaseModel;
import com.bodyworks.zu_jian_hua_example.mvp.presenter.MainPresenter;

/**
 * Created by treycc on 2017/3/28.
 */

public class MainModel extends MvpBaseModel<MainPresenter> {

    public MainModel(MainPresenter mainPresenter) {
        super(mainPresenter);
    }

    public String getShowText(String text) {
        return text + "  showtime!!!";
    }
}
