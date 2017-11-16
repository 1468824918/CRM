package com.lanou.hr.domain;

import java.util.List;

/**
 * 分页的 Bean
 * 1.当前页码:pageCode , pc
 * 2.总页数: totalPage tp 总记录数/每页记录数
 * 3.总记录数: totalRecord tr dao: 查询 select count(*)
 * 4.每页记录数: pageSize ps 10
 * 5.当前页的数据 beanList bl
 * 6.url
 */
public class PageBean<T> {
    private int pageCode;//当前页码 tr
//    private int totalPage; //总页码数tp
    private int totalRecord;//总记录数pr
    private int pageSize;//每页记录数ps
    private List<T> beanList;//当前页记录数
    private String url;//url后面的条件

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }
    /* 计算总页数 */
    public int getTotalPage() {
        //总记录数/每页记录数
        int tp = totalRecord/pageSize;
        return totalRecord%pageSize == 0 ? tp:tp+1;
    }

//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
