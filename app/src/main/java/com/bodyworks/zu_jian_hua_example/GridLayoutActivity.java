package com.bodyworks.zu_jian_hua_example;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by treycc on 2017/3/20.
 */

public class GridLayoutActivity extends AppCompatActivity {

    private static final String TAG = "width";
    private GridLayout gridLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridlayout);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        gridLayout = (GridLayout) findViewById(R.id.gridlayout);

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();// 创建了一张白纸
        windowManager.getDefaultDisplay().getMetrics(dm);// 给白纸设置宽高

//        获取单个ITEM宽度
        int widthPixels = dm.widthPixels;
        int heightPixels = dm.heightPixels;
        Log.w(TAG, "onCreate: " + widthPixels);
        Log.w(TAG, "onCreate: " + heightPixels);
        int gridItemMargin = getResources().getDimensionPixelSize(R.dimen.grid_item_margin);
        int gridMargin = getResources().getDimensionPixelSize(R.dimen.grid_margin);
        int totalWideMargin = 5 * 2 * gridItemMargin + gridMargin * 2;
        int totalHeightMargin = 3 * 2 * gridItemMargin + gridMargin * 2;
        int itemWidth = (widthPixels - totalWideMargin) / 5;
        int itemHeight = (heightPixels - totalHeightMargin) / 3;

        for (int i = 0; i < 2; i++) {
            FrameLayout framItem = new FrameLayout(this);
            GridLayout.Spec rowSpec = GridLayout.spec(0, 3);
            GridLayout.Spec colomnSpec = GridLayout.spec(i);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, colomnSpec);
            layoutParams.width = itemWidth;
            layoutParams.setGravity(Gravity.FILL_VERTICAL);
            layoutParams.setMargins(gridItemMargin, gridItemMargin, gridItemMargin, gridItemMargin);
            framItem.setLayoutParams(layoutParams);
            framItem.setBackgroundResource(R.drawable.shape_item_bg);
            gridLayout.addView(framItem);
        }

//        int height = gridLayout.getLayoutParams().height / 3;
//        Log.w(TAG, "onCreate: " + height);
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j < 5; j++) {
                FrameLayout framItem = new FrameLayout(GridLayoutActivity.this);
                GridLayout.Spec rowSpec = GridLayout.spec(i);
                GridLayout.Spec colomnSpec = GridLayout.spec(j, 1.0f);
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, colomnSpec);
                layoutParams.width = itemWidth;
                layoutParams.height = itemWidth;
                layoutParams.setMargins(gridItemMargin, gridItemMargin, gridItemMargin, gridItemMargin);
                framItem.setLayoutParams(layoutParams);
                framItem.setBackgroundResource(R.drawable.shape_item_bg);
                gridLayout.addView(framItem);
            }
        }


    }
}