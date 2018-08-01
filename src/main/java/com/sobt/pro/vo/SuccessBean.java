package com.sobt.pro.vo;

public class SuccessBean<T> {

    private String desc;//错误描述

    private Integer error;//错误码

    private T data;//返回数据

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
