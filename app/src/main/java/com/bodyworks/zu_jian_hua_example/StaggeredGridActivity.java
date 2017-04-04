package com.bodyworks.zu_jian_hua_example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;

import com.bodyworks.zu_jian_hua_example.adapter.Header0Adapter;
import com.bodyworks.zu_jian_hua_example.adapter.StaggeredGridAdapter;
import com.bodyworks.zu_jian_hua_example.entitiy.ComplicatedEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by treycc on 2017/4/2.
 */

public class StaggeredGridActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<ComplicatedEntity> straggData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        straggData = getStaggeredData(20);

//        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        RecyclerView header0 = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.item_header, recyclerView, false);
        header0.setLayoutManager(new GridLayoutManager(this, 3));
        header0.setAdapter(new Header0Adapter(R.layout.inside_header_0_item, getStaggeredData(6)));
        RecyclerView header1 = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.item_header, recyclerView, false);
        header1.setLayoutManager(new GridLayoutManager(this, 2));
        header1.setAdapter(new Header0Adapter(R.layout.inside_header_1_item, getStaggeredData(4)));

        StaggeredGridAdapter staggeredGridAdapter = new StaggeredGridAdapter(straggData);
        recyclerView.setAdapter(staggeredGridAdapter);
        staggeredGridAdapter.addHeaderView(header0);
        staggeredGridAdapter.addHeaderView(header1);

    }

    private List<ComplicatedEntity> getStaggeredData(int size) {
        List<ComplicatedEntity> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new ComplicatedEntity());
        }
        return list;
    }
}
