package com.mis.flowers.dto;
public class makeOrdersDto {
    /**
     * 订单编号
     */
    private Integer orderid;
    /**
     * 用户编号
     */
    private Integer userid;
    /**
     * 商品编号
     */
    private Integer goodsid;
    /**
     * 购买数量（大于等于1）
     */
    private String buycount;
    /**
     * 商品总价
     */
    private Float sumprice;
    /**
     * 收货人姓名
     */
    private String ordername;
    /**
     * 手机号
     */
    private String orderphone;
    /**
     * 收货地址
     */
    private String orderaddress;
    /**
     * 付款方式（0：线上支付，1货到付款）
     */
    private Integer pay;
    /**
     * 订单状态（0：已完成，1：已发货，2：待支付，3：待发货，4：待收货）
     */
    private Integer state;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getBuycount() {
        return buycount;
    }

    public void setBuycount(String buycount) {
        this.buycount = buycount;
    }

    public Float getSumprice() {
        return sumprice;
    }

    public void setSumprice(Float sumprice) {
        this.sumprice = sumprice;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrderphone() {
        return orderphone;
    }

    public void setOrderphone(String orderphone) {
        this.orderphone = orderphone;
    }

    public String getOrderaddress() {
        return orderaddress;
    }

    public void setOrderaddress(String orderaddress) {
        this.orderaddress = orderaddress;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}