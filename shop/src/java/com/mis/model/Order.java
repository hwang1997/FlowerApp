package com.mis.model;


public class Order {
    private int order_id;
    private String order_name;
    private String amount;
    private String phone;
    private String address;
    private String pay;
    private String state;
    private Goods good;
    private User user;
    
    public Order(){
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", order_name=" + order_name + ", amount=" + amount + ", phone=" + phone + ", address=" + address + ", pay=" + pay + ", state=" + state + ", good=" + good + ", user=" + user + '}';
    }
    
    

    
}
