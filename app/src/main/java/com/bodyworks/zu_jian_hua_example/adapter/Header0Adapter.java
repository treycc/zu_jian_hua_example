package com.bodyworks.zu_jian_hua_example.adapter;

import com.bodyworks.zu_jian_hua_example.entitiy.ComplicatedEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by treycc on 2017/4/2.
 */

public class Header0Adapter extends BaseQuickAdapter<ComplicatedEntity, BaseViewHolder> {

    public Header0Adapter(int layoutResId, List<ComplicatedEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ComplicatedEntity item) {

    }
}
