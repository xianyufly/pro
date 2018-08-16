package com.sobt.pro.dao.bean.ext;

import com.sobt.pro.dao.bean.TBootstrapTag;

import java.util.List;

public class TBootstrapTagExt extends TBootstrapTag {

    private List<TBootstrapTag> children;

    public List<TBootstrapTag> getChildren() {
        return children;
    }

    public void setChildren(List<TBootstrapTag> children) {
        this.children = children;
    }
}
