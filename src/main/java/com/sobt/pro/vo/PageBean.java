package com.sobt.pro.vo;

import javax.validation.constraints.*;

public class PageBean {
    @NotNull
    @Min(1)
    //每页条数
    private Integer rows;
    //第几页
    @NotNull
    @Min(1)
    private Integer page;
    //所有页数
    private Long totals;

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getPage() {
        return page;
    }

    public Long getTotals() {
        return totals;
    }

    public void setTotals(Long totals) {
        this.totals = totals;
    }
}
