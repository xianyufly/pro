package com.sobt.pro.dao;

import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.dao.func.TBootstrapResMapper;

import java.util.List;
import java.util.Map;

public interface TBootstrapResDao extends TBootstrapResMapper {

    /**
     * 随机查找2篇文章
     * @param param
     * @return
     */
    public List<TBootstrapRes> selectRandomRes(Map<String,Object> param);


}
