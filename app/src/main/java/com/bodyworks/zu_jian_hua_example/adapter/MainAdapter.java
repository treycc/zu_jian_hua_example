package com.bodyworks.zu_jian_hua_example.adapter;

import com.bodyworks.zu_jian_hua_example.R;
import com.bodyworks.zu_jian_hua_example.entitiy.Entity;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


/**
 * Created by treycc on 2017/4/2.
 */

public class MainAdapter extends BaseMultiItemQuickAdapter<Entity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MainAdapter(List<Entity> data) {
        super(data);
        addItemType(Entity.TEXT, R.layout.item_text_view);
        addItemType(Entity.IMG, R.layout.item_image_view);
        addItemType(Entity.IMG_TEXT, R.layout.item_img_text_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, Entity item) {
//        Slice slice = new Slice(helper.getConvertView());
//        slice.setRadius(10);
//        slice.setElevation(10);
    }
}
