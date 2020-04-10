package com.wanghuan.login.model;

public class Order {
    private int order_id;
    private User user;
    private Flowers flowers;
    private String amount;
    private String order_name;
    private String phone;
    private String address;
    private String pay;
    private String state;

//    public Order(int order_id, User user, Flowers flowers, String amount, String order_name, String phone, String address, String pay, String state) {
//        this.order_id = order_id;
//        this.user = user;
//        this.flowers = flowers;
//        this.amount = amount;
//        this.order_name = order_name;
//        this.phone = phone;
//        this.address = address;
//        this.pay = pay;
//        this.state = state;
//    }

    public Order(int order_id, String amount, String order_name, String phone, String address, String pay, String state) {
        this.order_id = order_id;
        this.amount = amount;
        this.order_name = order_name;
        this.phone = phone;
        this.address = address;
        this.pay = pay;
        this.state = state;
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Flowers getFlowers() {
//        return flowers;
//    }
//
//    public void setFlowers(Flowers flowers) {
//        this.flowers = flowers;
//    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
