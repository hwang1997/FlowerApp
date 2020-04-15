package com.wanghuan.login.model;

import java.io.Serializable;

public class Goods implements Serializable {
    private int goodsid;
    private String goodsname;
    private float goodsprice;
    private int goodscount;
    private String goodsdes;
    private String goodsimg;

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(float goodsprice) {
        this.goodsprice = goodsprice;
    }

    public int getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(int goodscount) {
        this.goodscount = goodscount;
    }

    public String getGoodsdes() {
        return goodsdes;
    }

    public void setGoodsdes(String goodsdes) {
        this.goodsdes = goodsdes;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", goodsprice=" + goodsprice +
                ", goodscount=" + goodscount +
                ", goodsdes='" + goodsdes + '\'' +
                ", goodsimg='" + goodsimg + '\'' +
                '}';
    }
}
