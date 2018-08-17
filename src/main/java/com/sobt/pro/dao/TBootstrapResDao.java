package com.sobt.pro.dao;

import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.dao.func.TBootstrapResMapper;

import java.util.List;
import java.util.Map;

public interface TBootstrapResDao extends TBootstrapResMapper {

    /**
     * 随机查找资源
     * @param param
     * @return
     */
    public List<TBootstrapRes> selectRandomRes(Map<String,Object> param);

    /**
     * 通过标签ID查找模板资源
     * @param param
     * @return
     */
    public List<TBootstrapRes> selectRandomResByTags(Map<String,Object> param);

}
