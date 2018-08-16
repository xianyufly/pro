package com.sobt.pro.service;

import com.sobt.pro.controller.paramDto.in.UserInDto;
import com.sobt.pro.controller.paramDto.out.UserOutDto;
import com.sobt.pro.vo.SuccessBean;

public interface UserService {

    /**
     * 登陆
     * @param param
     * @return
     */
    public SuccessBean<UserOutDto.LoginOutDto> login(UserInDto.LoginInDto param);

    /**
     * 初始化登陆数据
     * @param param
     * @return
     */
    public SuccessBean<UserOutDto.InitDataOutDto> initData(UserInDto.InitDataInDto param);


}
