package com.sobt.pro.service;

import com.sobt.pro.controller.paramDto.in.ArticleInDto;
import com.sobt.pro.controller.paramDto.out.ArticleOutDto;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 文章查询类
 */
public interface ArticleService {
    /**
     * 获取分页文章
     * @param param
     * @return
     */
    public SuccessBean<ArticleOutDto.GetArticleByPageOutDto> getArticleByPage(ArticleInDto.GetArticleByPageInDto param);

    /**
     * 获取文章内容
     * @param param
     * @return
     */
    public SuccessBean<ArticleOutDto.GetArticleDetailOutDto> getArticleDetail(ArticleInDto.GetArticleDetailInDto param);
}
