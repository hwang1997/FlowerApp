package com.wanghuan.login.model;

public class Flowers {
    private int good_id;
    private String good_name;
    private String price;
    private String count;
    private String des;
    private String pic;

    public Flowers(int good_id, String good_name, String price, String count, String des, String pic) {
        this.good_id = good_id;
        this.good_name = good_name;
        this.price = price;
        this.count = count;
        this.des = des;
        this.pic = pic;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
