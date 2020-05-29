package com.mis.flowers.dto;

public class GoodsDto {
    /**
     * 商品编号
     */
    private Integer goodsid;
    /**
     * 商品名称
     */
    private String goodsname;
    /**
     * 商品价格
     */
    private Float goodsprice;
    /**
     * 商品数量
     */
    private Integer goodscount;
    /**
     * 花语
     */
    private String goodsdes;
    /**
     * 商品图片
     */
    private String goodsimg;
    /**
     * 商品产地
     */
    private String goodsAddress;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Float goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Integer getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Integer goodscount) {
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

    public String getGoodsAddress() {
        return goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress) {
        this.goodsAddress = goodsAddress;
    }
}