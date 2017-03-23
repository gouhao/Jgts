package com.xdja.jwt.jgts.utils.gprsutils.repository;


import com.xdja.jwt.jgts.utils.gprsutils.entity.Page;

import java.util.LinkedHashMap;
import java.util.List;

public class XMLResponse {

    /*
    * <!--第一个Row代表英文字段名称-->
    * <!--第二个Row代表对应中文字段名称-->
    * <!--从第三个Row开始代表数据-->
    * */
    private LinkedHashMap<Integer, LinkedHashMap<Integer, String>> rows;
    private Page page;
    public List<String> relations;

    public LinkedHashMap<Integer, LinkedHashMap<Integer, String>> getRows() {
        return rows;
    }

    public void setRows(LinkedHashMap<Integer, LinkedHashMap<Integer, String>> rows) {
        this.rows = rows;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    /*
    * 获取指定下标的row
    * */
    public LinkedHashMap<Integer, String> getDataMap(int index) {
        if (rows == null) {
            return null;
        }
        if (index < 0 || index >= rows.size()) {
            return null;
        }
        return rows.get(index);
    }

    public boolean isEmpty() {
        return rows == null || rows.size() == 0;
    }

}
