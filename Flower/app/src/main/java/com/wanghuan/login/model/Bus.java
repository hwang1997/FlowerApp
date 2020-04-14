package com.wanghuan.login.model;

public class Bus {
    private FlowersRes flowers;
    private String buyCount;

    public Bus(FlowersRes flowers, String buyCount) {
        this.flowers = flowers;
        this.buyCount = buyCount;
    }

    public FlowersRes getFlowers() {
        return flowers;
    }

    public void setFlowers(FlowersRes flowers) {
        this.flowers = flowers;
    }

    public String getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(String buyCount) {
        this.buyCount = buyCount;
    }
}
