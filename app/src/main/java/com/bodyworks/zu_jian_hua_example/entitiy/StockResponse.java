package com.bodyworks.zu_jian_hua_example.entitiy;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by treycc on 2017/4/3.
 */

public class StockResponse {

    private List<StockInfo> amplitude_list;
    private List<StockInfo> down_list;
    private List<StockInfo> change_list;
    private List<StockInfo> increase_list;

    public List<StockInfo> getAmplitude_list() {
        return amplitude_list;
    }

    public void setAmplitude_list(List<StockInfo> amplitude_list) {
        this.amplitude_list = amplitude_list;
    }

    public List<StockInfo> getDown_list() {
        return down_list;
    }

    public void setDown_list(List<StockInfo> down_list) {
        this.down_list = down_list;
    }

    public List<StockInfo> getChange_list() {
        return change_list;
    }

    public void setChange_list(List<StockInfo> change_list) {
        this.change_list = change_list;
    }

    public List<StockInfo> getIncrease_list() {
        return increase_list;
    }

    public void setIncrease_list(List<StockInfo> increase_list) {
        this.increase_list = increase_list;
    }

    public static class StockInfo implements MultiItemEntity {
        public static final int STICK_TITLE = 1;
        public static final int DATA = 2;

        private int itemType;

        private String stickyTitle;

        private double rate;
        private double current_price;
        private String stock_code;
        private String stock_name;

        public StockInfo(int itemType, String stickyTitle) {
            this.itemType = itemType;
            this.stickyTitle = stickyTitle;
        }

        public StockInfo(int itemType, String stock_code, String stock_name) {
            this.itemType = itemType;
            this.stock_code = stock_code;
            this.stock_name = stock_name;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        public double getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(double current_price) {
            this.current_price = current_price;
        }

        public String getStock_code() {
            return stock_code;
        }

        public void setStock_code(String stock_code) {
            this.stock_code = stock_code;
        }

        public String getStock_name() {
            return stock_name;
        }

        public void setStock_name(String stock_name) {
            this.stock_name = stock_name;
        }

        public String getStickyTitle() {
            return stickyTitle;
        }

        public void setStickyTitle(String stickyTitle) {
            this.stickyTitle = stickyTitle;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }
    }
}
