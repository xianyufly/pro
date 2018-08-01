package com.sobt.pro.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.WYInDto;
import com.sobt.pro.controller.paramDto.out.WYOutDto;
import com.sobt.pro.service.WYService;
import com.sobt.pro.vo.SuccessBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "wy",produces="application/json;charset=UTF-8")
public class WYController {
    Logger log= LoggerFactory.getLogger(this.getClass());


    @Resource
    WYService wyService;

    @RequestMapping(value = "diskFileBatchDownload")
    public SuccessBean<WYOutDto.DiskFileBatchDownloadOutDto> diskFileBatchDownload(@RequestBody @Valid WYInDto.DiskFileBatchDownloadInDto param, BindingResult result,HttpServletRequest request){
        log.info("--------------diskFileBatchDownload-请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<WYOutDto.DiskFileBatchDownloadOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()) {
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return wyService.diskFileBatchDownload(param);
    }

}
