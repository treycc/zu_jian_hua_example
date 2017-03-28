package com.bodyworks.zu_jian_hua_example.mvp.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by treycc on 2017/3/28.
 */

@Module
public class MainModule {

    @Provides
    Person providePerson(){
        System.out.println("this is person from mainModule");
        return new Person();
    }

}
