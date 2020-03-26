package com.wanghuan.login.model;

public class Addr {
    private String address;
    private String name;
    private String tel;

    public Addr(String address, String name, String tel) {
        this.address = address;
        this.name = name;
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
