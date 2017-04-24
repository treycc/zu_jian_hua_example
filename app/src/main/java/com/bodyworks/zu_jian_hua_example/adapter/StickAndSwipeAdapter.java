package com.bodyworks.zu_jian_hua_example.adapter;

import com.bodyworks.zu_jian_hua_example.R;
import com.bodyworks.zu_jian_hua_example.entitiy.StockResponse;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by treycc on 2017/4/3.
 */

public class StickAndSwipeAdapter extends BaseMultiItemQuickAdapter<StockResponse.StockInfo, BaseViewHolder> {


    public StickAndSwipeAdapter(List<StockResponse.StockInfo> data) {
        super(data);
        addItemType(StockResponse.StockInfo.STICK_TITLE, R.layout.item_sticky_head);
        addItemType(StockResponse.StockInfo.DATA, R.layout.item_swipe);
    }


    @Override
    protected void convert(BaseViewHolder helper, StockResponse.StockInfo item) {
        if (item.getItemType() == StockResponse.StockInfo.DATA) {
            helper.setText(R.id.mainText, item.getStock_name())
                    .setText(R.id.subText, item.getStock_code())
                    .addOnClickListener(R.id.rowButton)
                    .addOnClickListener(R.id.rowButton1);
        } else if (item.getItemType() == StockResponse.StockInfo.STICK_TITLE) {
            helper.setText(R.id.title, item.getStickyTitle())
                    .addOnClickListener(R.id.more);
        }
    }
}
