package com.sobt.pro.constant;

import com.alibaba.fastjson.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public enum SatusEnum {

    Delete("删除",1),Normal("正常",0);



    // 成员变量
    private String msg;
    private int code;
    // 构造方法
    private SatusEnum(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

}
