package com.sobt.pro.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.SubjectInDto;
import com.sobt.pro.controller.paramDto.out.ArticleOutDto;
import com.sobt.pro.controller.paramDto.out.SubjectOutDto;
import com.sobt.pro.service.ArticleService;
import com.sobt.pro.service.SubjectService;
import com.sobt.pro.vo.PythonConfig;
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
@RequestMapping(value = "subject",produces="application/json;charset=UTF-8")
public class SubjectController {

    Logger log= LoggerFactory.getLogger(this.getClass());

    @Resource
    SubjectService subjectService;

    @RequestMapping(value = "getSubjectList")
    public SuccessBean<SubjectOutDto.GetSubjectListOutDto> getSubjectList(@RequestBody @Valid SubjectInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<SubjectOutDto.GetSubjectListOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()) {
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return subjectService.getSubjectList(param);
    }

}
