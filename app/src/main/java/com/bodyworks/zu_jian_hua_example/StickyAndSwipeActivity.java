package com.bodyworks.zu_jian_hua_example;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bodyworks.zu_jian_hua_example.adapter.StickAndSwipeAdapter;
import com.bodyworks.zu_jian_hua_example.entitiy.StockResponse;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.nikhilpanju.recyclerviewenhanced.RecyclerTouchListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


/**
 * Created by treycc on 2017/4/3.
 */

public class StickyAndSwipeActivity extends AppCompatActivity {

    private static final String TAG = "sticky";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private StickAndSwipeAdapter stickAndSwipeAdapter;

    private View stickyHeadLayout;
    private String strFromAssets;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_swipe);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        stickyHeadLayout = findViewById(R.id.stick_head_layout);
        stickyHeadLayout.setVisibility(View.GONE);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        stickAndSwipeAdapter = new StickAndSwipeAdapter(null);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(stickAndSwipeAdapter);

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                strFromAssets = getStrFromAssets(StickyAndSwipeActivity.this, "rasking.json");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parseAndSetData(strFromAssets);
                    }
                });
            }
        });


        /**
         * 炫富条，使用分割线，布局拓展性差，不实用
         */
//        FloatingDecoration decoration = new FloatingDecoration(this, new FloatingDecoration.DecorationCallback() {
//            @Override
//            public String getGroupLabel(int position) {
//                return data.get(position).getTitle();
//            }
//        });
//        recyclerView.addItemDecoration(decoration);


        //左滑,更改adapter的data类型条目的布局为swipe
        RecyclerTouchListener recyclerTouchListener = new RecyclerTouchListener(this, recyclerView);
        recyclerTouchListener
                .setIndependentViews(R.id.rowButton)
                .setViewsToFade(R.id.rowButton)
                .setClickable(new RecyclerTouchListener.OnRowClickListener() {
                    @Override
                    public void onRowClicked(int position) {
                        Snackbar.make(recyclerView, (position + 1) + "行被点击" + ":::onRowClicked", Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onIndependentViewClicked(int independentViewID, int position) {
                        Snackbar.make(recyclerView, (position + 1) + "行被点击" + ":::onIndependentViewClicked", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .setLongClickable(true, new RecyclerTouchListener.OnRowLongClickListener() {
                    @Override
                    public void onRowLongClicked(int position) {
                        Snackbar.make(recyclerView, (position + 1) + "行被长按", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .setSwipeOptionViews(R.id.add, R.id.edit, R.id.change)
                .setSwipeable(R.id.rowFG, R.id.rowBG, new RecyclerTouchListener.OnSwipeOptionsClickListener() {
                    @Override
                    public void onSwipeOptionClicked(int viewID, int position) {
                        String message = "";
                        if (viewID == R.id.add) {
                            message += "Add";
                        } else if (viewID == R.id.edit) {
                            message += "Edit";
                        } else if (viewID == R.id.change) {
                            message += "Change";
                        }
                        message += " clicked for row " + (position + 1);
                        Snackbar.make(recyclerView, (position + 1) + message, Snackbar.LENGTH_SHORT).show();
                    }
                });
        recyclerView.addOnItemTouchListener(recyclerTouchListener);

//        炫富条
        stickyHeadLayout.setVisibility(View.VISIBLE);
        recyclerView.addOnScrollListener(new StickyScrollListener(stickAndSwipeAdapter, stickyHeadLayout));
        //点击
//        stickAndSwipeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Snackbar.make(findViewById(android.R.id.content), (position + 1) + "行被点击", Snackbar.LENGTH_SHORT).show();
//            }
//        });
//
//        stickAndSwipeAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
//                Snackbar.make(findViewById(android.R.id.content), (position + 1) + "行被长按", Snackbar.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//
//        stickAndSwipeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                int id = view.getId();
//                switch (id) {
//                    case R.id.rowButton:
//                        Snackbar.make(findViewById(android.R.id.content), (position + 1) + "行button被点击", Snackbar.LENGTH_SHORT).show();
//                        break;
//                    case R.id.rowButton1:
//                        Snackbar.make(findViewById(android.R.id.content), (position + 1) + "行button1被点击", Snackbar.LENGTH_SHORT).show();
//                        break;
//                    case R.id.more:
//                        Snackbar.make(findViewById(android.R.id.content), (position + 1) + "行more被点击", Snackbar.LENGTH_SHORT).show();
//                        break;
//                }
//                return false;
//            }
//        });

        stickAndSwipeAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (loadMoreCount < 2) {
                            if (isErr) {
                                stickAndSwipeAdapter.addData(loadMoreData(strFromAssets));
                                stickAndSwipeAdapter.loadMoreComplete();
                                loadMoreCount++;
                            } else {
                                isErr = true;
                                stickAndSwipeAdapter.loadMoreFail();
                            }

                        } else {
                            stickAndSwipeAdapter.loadMoreEnd();
                        }

                    }
                }, 1000);


            }
        }, recyclerView);

        stickAndSwipeAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);


    }

    int loadMoreCount = 0;
    boolean isErr;

    public static String getStrFromAssets(Context context, String name) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(name);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private void parseAndSetData(String result) {
        Gson gson = new Gson();

        StockResponse stockResponse = gson.fromJson(result, StockResponse.class);

        List<StockResponse.StockInfo> data = new ArrayList<>();

        data.add(new StockResponse.StockInfo(StockResponse.StockInfo.STICK_TITLE, "涨幅榜"));
        for (StockResponse.StockInfo info : stockResponse.getIncrease_list()) {
            info.setItemType(StockResponse.StockInfo.DATA);
            info.setStickyTitle("涨幅榜");
            data.add(info);
        }

        data.add(new StockResponse.StockInfo(StockResponse.StockInfo.STICK_TITLE, "跌幅榜"));
        for (StockResponse.StockInfo info : stockResponse.getDown_list()) {
            info.setItemType(StockResponse.StockInfo.DATA);
            info.setStickyTitle("跌幅榜");
            data.add(info);
        }

//        data.add(new StockResponse.StockInfo(StockResponse.StockInfo.STICK_TITLE, "换手率"));
//        for (StockResponse.StockInfo info : stockResponse.getChange_list()) {
//            info.setItemType(StockResponse.StockInfo.DATA);
//            info.setStickyTitle("换手率");
//            data.add(info);
//        }
//
//        data.add(new StockResponse.StockInfo(StockResponse.StockInfo.STICK_TITLE, "振幅榜"));
//        for (StockResponse.StockInfo info : stockResponse.getAmplitude_list()) {
//            info.setItemType(StockResponse.StockInfo.DATA);
//            info.setStickyTitle("振幅榜");
//            data.add(info);
//        }

        stickAndSwipeAdapter.setNewData(data);
    }

    public List<StockResponse.StockInfo> loadMoreData(String result) {
        Gson gson = new Gson();

        StockResponse stockResponse = gson.fromJson(result, StockResponse.class);

        List<StockResponse.StockInfo> data = new ArrayList<>();

        data.add(new StockResponse.StockInfo(StockResponse.StockInfo.STICK_TITLE, "换手率"));
        for (StockResponse.StockInfo info : stockResponse.getChange_list()) {
            info.setItemType(StockResponse.StockInfo.DATA);
            info.setStickyTitle("换手率");
            data.add(info);
        }

//        data.add(new StockResponse.StockInfo(StockResponse.StockInfo.STICK_TITLE, "振幅榜"));
//        for (StockResponse.StockInfo info : stockResponse.getAmplitude_list()) {
//            info.setItemType(StockResponse.StockInfo.DATA);
//            info.setStickyTitle("振幅榜");
//            data.add(info);
//        }

        return data;
    }

}
