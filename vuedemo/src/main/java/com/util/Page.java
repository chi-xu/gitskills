package com.util;

import java.util.List;

public class Page {
    
    //每页记录数
    //public static final int PAGE_SIZE = 6;
    private int pageSize;
    //当前页
    private int currPage ;
    
    //总记录数
    private int totalCount;
    
    //总页数
    private int totalPage;
    
    //数据
    private List data;
    
    
    /**
     * 计算总页数
     */
    
    public void init() {
        if(this.totalCount %pageSize == 0) {
            this.totalPage = this.totalCount/pageSize;
        }else {
            this.totalPage = this.totalCount/pageSize+1;
        }
    }


    
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }




    public int getCurrPage() {
        return currPage;
    }


    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }


    public int getTotalCount() {
        return totalCount;
    }


    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    public int getTotalPage() {
        return totalPage;
    }


    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    public List getData() {
        return data;
    }


    public void setData(List data) {
        this.data = data;
    }
    
    public  int getPageSize() {
        return pageSize;
    }
    

}
