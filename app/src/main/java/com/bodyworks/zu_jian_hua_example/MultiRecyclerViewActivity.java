package com.bodyworks.zu_jian_hua_example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bodyworks.zu_jian_hua_example.adapter.MainAdapter;
import com.bodyworks.zu_jian_hua_example.entitiy.Entity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chauncey.floatingdecoration.FloatingDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by treycc on 2017/4/2.
 */

public class MultiRecyclerViewActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<Entity> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        data = getData();

        MainAdapter mainAdapter = new MainAdapter(data);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mainAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mainAdapter);

//        FloatingDecoration decoration = new FloatingDecoration(this, new FloatingDecoration.DecorationCallback() {
//            @Override
//            public String getGroupLabel(int position) {
//                return data.get(position).getTitle();
//            }
//        });
//        recyclerView.addItemDecoration(decoration);
    }

    private List<Entity> getData() {
        List<Entity> list = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            list.add(new Entity(Entity.IMG, Entity.IMG_SPAN_SIZE, "必须的"));
            list.add(new Entity(Entity.TEXT, Entity.TEXT_SPAN_SIZE));
            list.add(new Entity(Entity.IMG_TEXT, Entity.IMG_TEXT_SPAN_SIZE));
            list.add(new Entity(Entity.IMG_TEXT, Entity.IMG_TEXT_SPAN_SIZE_MIN));
            list.add(new Entity(Entity.IMG_TEXT, Entity.IMG_TEXT_SPAN_SIZE_MIN));
        }
        return list;
    }
}
