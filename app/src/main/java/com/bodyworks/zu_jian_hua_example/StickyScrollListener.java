package com.bodyworks.zu_jian_hua_example;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bodyworks.zu_jian_hua_example.entitiy.StockResponse;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


/**
 * Created by treycc on 2017/4/3.
 */

public class StickyScrollListener extends RecyclerView.OnScrollListener {
    private static final String TAG = "sticky";
    private int height = 0;
    private View stickyHeadLayout;
    private TextView stickyTitle;
    private BaseMultiItemQuickAdapter<StockResponse.StockInfo, BaseViewHolder> baseMultiItemQuickAdapter;

    public StickyScrollListener(BaseMultiItemQuickAdapter<StockResponse.StockInfo, BaseViewHolder> baseMultiItemQuickAdapter, View stickyHeadLayout) {
        super();
        this.stickyHeadLayout = stickyHeadLayout;
        this.baseMultiItemQuickAdapter = baseMultiItemQuickAdapter;
        this.stickyTitle = (TextView) stickyHeadLayout.findViewById(R.id.title);
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        height = stickyHeadLayout.getHeight();
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        Log.w(TAG, "onScrolled: "+baseMultiItemQuickAdapter.getData().get(firstVisibleItemPosition).getStickyTitle());
        stickyTitle.setText(baseMultiItemQuickAdapter.getData().get(firstVisibleItemPosition).getStickyTitle());

        int firstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
        int itemViewType = baseMultiItemQuickAdapter.getItemViewType(firstCompletelyVisibleItemPosition);
        if (itemViewType == StockResponse.StockInfo.STICK_TITLE) {
            View recyclerItem = layoutManager.findViewByPosition(firstCompletelyVisibleItemPosition);
            int top = recyclerItem.getTop();
            if (top <= height) {
                ViewCompat.setTranslationY(stickyHeadLayout, top - height);
            }
        } else {
            ViewCompat.setTranslationY(stickyHeadLayout, 0);
        }
    }
}
