package com.mis.flowers.util;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

    private List<T> items;//存放数据列表

    private Integer pageIndex;//当前页

    private Integer pageSize;//每页的条数

    private Integer totalCount;//总条数

    private Integer totalPage;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        //计算总页数
        this.totalPage = (int) (Math.ceil((this.totalCount*1.0/this.pageSize)));
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Page(List<T> items, int totalCount){
        this.items =items;
        this.totalCount =totalCount;
    }
    public Page(){

    }
}
