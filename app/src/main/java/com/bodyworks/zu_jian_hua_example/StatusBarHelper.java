package com.bodyworks.zu_jian_hua_example;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by treycc on 2017/3/21.
 */

public class StatusBarHelper {

    private static final int FAKE_STATUS_BAR_VIEW_ID = R.id.statusbarutil_fake_status_bar_view;
    private static final String TAG = "statusBar";

    public static void setActColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            addFakeStatusView(activity, color);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            addFakeStatusView(activity, color);
        }
    }

    private static void addFakeStatusView(Activity activity, int color) {
        ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
        ViewGroup parent = (ViewGroup) contentView.getParent();
        Log.w(TAG, "setActColor: " + parent.toString());
        View fakeStatusBarView = parent.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (fakeStatusBarView != null) {
            if (fakeStatusBarView.getVisibility() == View.GONE) {
                fakeStatusBarView.setVisibility(View.VISIBLE);
            }
            fakeStatusBarView.setBackgroundColor(color);
        } else {
            parent.addView(createStatusBarView(activity, color), 0);
        }
    }

    private static void fitSystemWindows(Activity activity) {
        ViewGroup parent = (ViewGroup) activity.findViewById(android.R.id.content);
        for (int i = 0, count = parent.getChildCount(); i < count; i++) {
            View childView = parent.getChildAt(i);
            if (childView instanceof ViewGroup) {
                childView.setFitsSystemWindows(true);
                ((ViewGroup) childView).setClipToPadding(true);
            }
        }
    }

    private static View createStatusBarView(Activity activity, int color) {
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(color);
        statusBarView.setId(FAKE_STATUS_BAR_VIEW_ID);
        return statusBarView;
    }

    private static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

}
