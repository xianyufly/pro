package com.sobt.pro.dao;

import com.sobt.pro.dao.bean.TArticle;
import com.sobt.pro.dao.func.TArticleMapper;

import java.util.List;
import java.util.Map;

public interface TArticleDao extends TArticleMapper {

    /**
     * 随机查找2篇文章
     * @param param
     * @return
     */
    public List<TArticle> selectRandomArticle(Map<String,Object> param);

}
