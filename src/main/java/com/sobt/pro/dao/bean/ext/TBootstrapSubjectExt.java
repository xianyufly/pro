package com.sobt.pro.dao.bean.ext;

import com.sobt.pro.dao.bean.TBootstrapSubject;

import java.util.List;

public class TBootstrapSubjectExt extends TBootstrapSubject {

    private List<TBootstrapSubject> children;

    public List<TBootstrapSubject> getChildren() {
        return children;
    }

    public void setChildren(List<TBootstrapSubject> children) {
        this.children = children;
    }
}
