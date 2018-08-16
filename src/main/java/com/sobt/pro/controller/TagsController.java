package com.sobt.pro.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.TagsInDto;
import com.sobt.pro.controller.paramDto.out.TagsOutDto;
import com.sobt.pro.dao.bean.TBootstrapTag;
import com.sobt.pro.service.TagsService;
import com.sobt.pro.vo.SuccessBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "tags",produces="application/json;charset=UTF-8")
public class TagsController {
    Logger log= LoggerFactory.getLogger(this.getClass());

    @Resource
    TagsService TagsService;

    @RequestMapping(value = "parentLevelTags")
    public SuccessBean<TagsOutDto.ParentLevelTagsOutDto> parentLevelTags(@RequestBody @Valid TagsInDto.ParentLevelTagsInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<TagsOutDto.ParentLevelTagsOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return TagsService.parentLevelTags(param);
    }

    @RequestMapping(value = "tagsData")
    public SuccessBean<TagsOutDto.TagsDataOutDto> tagsData(@RequestBody @Valid TagsInDto.TagsDataInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<TagsOutDto.TagsDataOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return TagsService.TagsData(param);
    }

    @RequestMapping(value = "saveTags")
    public SuccessBean saveTags(@RequestBody TBootstrapTag param){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        return TagsService.saveTags(param);
    }

    @RequestMapping(value = "editTags")
    public SuccessBean editTags(@RequestBody TBootstrapTag param){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        return TagsService.editTags(param);
    }

    @RequestMapping(value = "deleteTags")
    public SuccessBean deleteTags(@RequestBody TBootstrapTag param){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        return TagsService.deleteTags(param);
    }
}
