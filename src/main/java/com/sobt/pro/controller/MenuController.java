package com.sobt.pro.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.MenuInDto;
import com.sobt.pro.controller.paramDto.out.ArticleOutDto;
import com.sobt.pro.controller.paramDto.out.MenuOutDto;
import com.sobt.pro.dao.bean.TBootstrapSubject;
import com.sobt.pro.service.MenuService;
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
@RequestMapping(value = "menu",produces="application/json;charset=UTF-8")
public class MenuController {

    Logger log= LoggerFactory.getLogger(this.getClass());
    @Resource
    MenuService menuService;

    @RequestMapping(value = "parentLevelMenu")
    public SuccessBean<MenuOutDto.ParentLevelMenuOutDto> parentLevelMenu(@RequestBody @Valid MenuInDto.ParentLevelMenuInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<MenuOutDto.ParentLevelMenuOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return menuService.parentLevelMenu(param);
    }

    @RequestMapping(value = "menuData")
    public SuccessBean<MenuOutDto.MenuDataOutDto> menuData(@RequestBody @Valid MenuInDto.MenuDataInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<MenuOutDto.MenuDataOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return menuService.menuData(param);
    }

    @RequestMapping(value = "saveMenu")
    public SuccessBean saveMenu(@RequestBody TBootstrapSubject param){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        return menuService.saveMenu(param);
    }

    @RequestMapping(value = "editMenu")
    public SuccessBean editMenu(@RequestBody TBootstrapSubject param){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        return menuService.editMenu(param);
    }

    @RequestMapping(value = "deleteMenu")
    public SuccessBean deleteMenu(@RequestBody TBootstrapSubject param){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        return menuService.deleteMenu(param);
    }

}
