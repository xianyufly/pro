package com.sobt.pro.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.ArticleInDto;
import com.sobt.pro.controller.paramDto.out.ArticleOutDto;
import com.sobt.pro.service.ArticleService;
import com.sobt.pro.vo.SuccessBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "article",produces="application/json;charset=UTF-8")
public class ArticleController {

    Logger log= LoggerFactory.getLogger(this.getClass());

    @Resource
    ArticleService articleService;

    @RequestMapping(value = "getArticleByPage")
    public SuccessBean<ArticleOutDto.GetArticleByPageOutDto> getArticleByPage(@RequestBody @Valid ArticleInDto.GetArticleByPageInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<ArticleOutDto.GetArticleByPageOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return articleService.getArticleByPage(param);
    }

    @RequestMapping(value = "getArticleDetail")
    public SuccessBean<ArticleOutDto.GetArticleDetailOutDto> getArticleDetail(@RequestBody @Valid ArticleInDto.GetArticleDetailInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<ArticleOutDto.GetArticleDetailOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return articleService.getArticleDetail(param);
    }
}
