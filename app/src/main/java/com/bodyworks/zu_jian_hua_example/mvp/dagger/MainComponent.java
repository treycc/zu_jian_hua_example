package com.bodyworks.zu_jian_hua_example.mvp.dagger;


import com.bodyworks.zu_jian_hua_example.mvp.MVPActivity;

import dagger.Component;

/**
 * Created by treycc on 2017/3/28.
 */

@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MVPActivity mvpActivity);
}
