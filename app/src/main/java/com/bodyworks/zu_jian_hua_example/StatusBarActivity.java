package com.bodyworks.zu_jian_hua_example;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.r0adkll.slidr.Slidr;

import me.yokeyword.swipebackfragment.SwipeBackActivity;


/**
 * Created by treycc on 2017/3/21.
 */

public class StatusBarActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Slidr.attach(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        StatusBarHelper.setActColor(this, getResources().getColor(R.color.colorPrimaryDark));
    }

    public void grid(View v) {
        startActivity(new Intent(this, GridLayoutActivity.class));
    }

}