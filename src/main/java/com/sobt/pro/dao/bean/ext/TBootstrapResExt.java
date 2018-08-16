package com.sobt.pro.dao.bean.ext;

import com.sobt.pro.dao.bean.TBootstrapRes;

import java.util.List;

public class TBootstrapResExt extends TBootstrapRes {

    private String subjectName;

    private List<Integer> tagList;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Integer> getTagList() {
        return tagList;
    }

    public void setTagList(List<Integer> tagList) {
        this.tagList = tagList;
    }
}
