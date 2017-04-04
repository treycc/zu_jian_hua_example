package com.bodyworks.zu_jian_hua_example.adapter;

import com.bodyworks.zu_jian_hua_example.R;
import com.bodyworks.zu_jian_hua_example.entitiy.ComplicatedEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by treycc on 2017/4/2.
 */

public class StaggeredGridAdapter extends BaseQuickAdapter<ComplicatedEntity, BaseViewHolder> {


    public StaggeredGridAdapter(List<ComplicatedEntity> data) {
        super(R.layout.item_staggered, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ComplicatedEntity item) {
//        if (helper.getAdapterPosition() % 5 == 0) {
//            StaggeredGridLayoutManager.LayoutParams params =
//                    (StaggeredGridLayoutManager.LayoutParams) helper.getConvertView().getLayoutParams();
//            params.setFullSpan(true);
//            helper.getConvertView().setLayoutParams(params);
//        }
        if (helper.getAdapterPosition() % 2 == 0) {
            helper.setText(R.id.text, "这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述");
        } else {
            helper.setText(R.id.text, "这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述这是表述");
        }


    }
}
