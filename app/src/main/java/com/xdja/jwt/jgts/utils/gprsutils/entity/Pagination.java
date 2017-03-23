package com.xdja.jwt.jgts.utils.gprsutils.entity;


import java.util.ArrayList;
import java.util.List;

/*
* 分页数据实体
* */
public class Pagination<T> {

    private List<T> list;
    private Page page;
    public List<String> relations;

    public Pagination() {
        this.list = new ArrayList<>();
    }

    public Pagination(Page page) {
        this();
        this.page = page;
    }

    /////////////////////////
    public void add(T data) {
        list.add(data);
    }

    public void addAll(List<T> dataList) {
        list.addAll(dataList);
    }

    public int size() {
        return list == null ? 0 : list.size();
    }

    public int totalRecord() {
        return page == null ? 0 : page.getTotalLen();
    }

    public int currentPage() {
        return page == null ? 1 : (int) Math.ceil(page.getCurrentLen() * 1.0D / page.getSize());
    }

    public boolean hasMore() {
        if (page!=null &&  page.getCurrentLen() >= page.getSize()){
            return true;
        }
        return false;
    }

    public T get(int index) {
        if (list == null) {
            return null;
        }
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    public boolean isEmpty() {
        return list == null || list.size() == 0;
    }

    /////////////////////////
    public List<T> getList() {
        return list;
    }

    public Page getPage() {
        return page;
    }
}
