package com.mis.flowers.dto;

import com.mis.flowers.entity.Users;

import java.util.ArrayList;
import java.util.List;

public class batchDeleteDto {
    private List list;
    private Integer length;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
