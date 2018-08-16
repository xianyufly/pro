package com.sobt.pro.dao.bean;

public class TBootstrapTag {
    private Integer tid;

    private String text;

    private Integer status;

    private Integer pTid;

    private String code;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getpTid() {
        return pTid;
    }

    public void setpTid(Integer pTid) {
        this.pTid = pTid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}