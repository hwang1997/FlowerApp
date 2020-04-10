package com.wanghuan.login.model;

public class Bus {
    private Flowers flowers;
    private String buyCount;

    public Bus(Flowers flowers, String buyCount) {
        this.flowers = flowers;
        this.buyCount = buyCount;
    }

    public Flowers getFlowers() {
        return flowers;
    }

    public void setFlowers(Flowers flowers) {
        this.flowers = flowers;
    }

    public String getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(String buyCount) {
        this.buyCount = buyCount;
    }
}
