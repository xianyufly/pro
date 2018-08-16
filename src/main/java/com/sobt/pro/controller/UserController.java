package com.sobt.pro.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.UserInDto;
import com.sobt.pro.controller.paramDto.out.UserOutDto;
import com.sobt.pro.service.UserService;
import com.sobt.pro.util.CreateImageCode;
import com.sobt.pro.vo.SuccessBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "user",produces="application/json;charset=UTF-8")
public class UserController {

    Logger log= LoggerFactory.getLogger(this.getClass());

    @Resource
    UserService userService;
    @Resource
    HttpSession session;

    @RequestMapping("login")
    @ResponseBody
    public SuccessBean<UserOutDto.LoginOutDto> login(@RequestBody @Valid UserInDto.LoginInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<UserOutDto.LoginOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return userService.login(param);
    }

    @RequestMapping("initData")
    @ResponseBody
    public SuccessBean<UserOutDto.InitDataOutDto> initData(@RequestBody @Valid UserInDto.InitDataInDto param, BindingResult result){
        log.info("--------------请求参数:"+ JSONObject.toJSONString(param));
        SuccessBean<UserOutDto.InitDataOutDto> successBean=new SuccessBean<>();
        if(result.hasErrors()){
            successBean.setError(MsgEnum.Param_Error.getCode());
            successBean.setDesc(MsgEnum.Param_Error.getMsg(result));
            return successBean;
        }
        return userService.initData(param);
    }

    /**
     * 验证码初始化
     * @return
     * @throws IOException
     */
    @RequestMapping("createAuthCode")
    @ResponseBody
    public void createAuthCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成验证码对象
        CreateImageCode vCode = new CreateImageCode(100,45,4,10);
        Map<String, Object> map = new HashMap<String, Object>();
        // 验证码保存到session
        map.put("code", vCode.getCode());
        map.put("code_img", vCode.getBuffImg());
        session.setAttribute("code", vCode.getCode());
        BufferedImage image = (BufferedImage) map.get("code_img");
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }


}
