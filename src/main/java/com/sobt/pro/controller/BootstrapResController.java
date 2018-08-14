package com.sobt.pro.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.ArticleInDto;
import com.sobt.pro.controller.paramDto.in.BootstrapResInDto;
import com.sobt.pro.controller.paramDto.out.ArticleOutDto;
import com.sobt.pro.controller.paramDto.out.BootstrapResOutDto;
import com.sobt.pro.service.BootstrapResService;
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
@RequestMapping(value = "bootRes",produces="application/json;charset=UTF-8")
public class BootstrapResController {

    Logger log= LoggerFactory.getLogger(this.getClass());

    @Resource
    BootstrapResService bootstrapResService;

    @RequestMapping(value = "getBootstrapResByPage")
    public SuccessBean<BootstrapResOutDto.GetBootstrapResByPageOutDto> getBootstrapResByPage(@RequestBody @Valid BootstrapResInDto.GetBootstrapResByPageInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<BootstrapResOutDto.GetBootstrapResByPageOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return bootstrapResService.getBootstrapResByPage(param);
    }

    @RequestMapping(value = "getBootstrapResDetail")
    public SuccessBean<BootstrapResOutDto.GetBootstrapResDetailOutDto> getBootstrapResDetail(@RequestBody @Valid BootstrapResInDto.GetBootstrapResDetailInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<BootstrapResOutDto.GetBootstrapResDetailOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return bootstrapResService.getBootstrapResDetail(param);
    }
}
