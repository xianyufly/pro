package com.sobt.pro.dao;

import com.sobt.pro.dao.bean.TBootstrapTag;
import com.sobt.pro.dao.func.TBootResTagMapper;

import java.util.List;

public interface TBootResTagDao extends TBootResTagMapper {

    public void deleteByResId(Integer resId);

    public List<Integer> getTagIdByResId(Integer resId);

    public List<TBootstrapTag> getTagByResId(Integer resId);
}
