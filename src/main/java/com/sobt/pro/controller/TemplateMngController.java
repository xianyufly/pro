package com.sobt.pro.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.TemplateMngInDto;
import com.sobt.pro.controller.paramDto.out.TemplateMngOutDto;
import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.service.TemplateMngService;
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
@RequestMapping(value = "templateMng",produces="application/json;charset=UTF-8")
public class TemplateMngController {

    Logger log= LoggerFactory.getLogger(this.getClass());

    @Resource
    TemplateMngService templateMngService;

    @RequestMapping(value = "plat/templateData")
    public SuccessBean<TemplateMngOutDto.TemplateDataOutDto> templateData(@RequestBody @Valid TemplateMngInDto.TemplateDataInDto param , BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<TemplateMngOutDto.TemplateDataOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return templateMngService.templateData(param);
    }

    @RequestMapping(value = "plat/editTemplate")
    public SuccessBean editTemplate(@RequestBody @Valid TemplateMngInDto.EditTemplateInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return templateMngService.editTemplate(param);
    }

    @RequestMapping(value = "plat/deleteTemplate")
    public SuccessBean deleteTemplate(@RequestBody @Valid TBootstrapRes param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return templateMngService.deleteTemplate(param);
    }

    @RequestMapping(value = "plat/menuList")
    public SuccessBean<TemplateMngOutDto.MenuListOutDto> menuList(@RequestBody @Valid TemplateMngInDto.MenuListInDto param, BindingResult result){

        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<TemplateMngOutDto.MenuListOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return templateMngService.menuList(param);
    }

    @RequestMapping(value = "plat/tagList")
    public SuccessBean<TemplateMngOutDto.TagsListOutDto> tagList(@RequestBody @Valid TemplateMngInDto.TagsListInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<TemplateMngOutDto.TagsListOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return templateMngService.tagList(param);
    }

}
