package com.bodyworks.zu_jian_hua_example.entitiy;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by treycc on 2017/4/3.
 */

public class MultiStockEntity implements MultiItemEntity {

    public static final int STICK_TITLE = 1;
    public static final int DATA = 2;

    private int itemType;
    private String title;
    private String stockName;
    private String stockCode;

    public MultiStockEntity(int itemType, String title) {
        this.itemType = itemType;
        this.title = title;
    }

    public MultiStockEntity(int itemType, String stockName, String stockCode) {
        this.itemType = itemType;
        this.stockName = stockName;
        this.stockCode = stockCode;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
