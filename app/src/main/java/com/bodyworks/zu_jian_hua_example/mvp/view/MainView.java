package com.bodyworks.zu_jian_hua_example.mvp.view;

/**
 * Created by treycc on 2017/3/27.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void loadDataComplate(String loadedText);

    void changeName(String chageText);
}
