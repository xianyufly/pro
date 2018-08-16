package com.sobt.pro.service;

import com.sobt.pro.controller.paramDto.in.MenuInDto;
import com.sobt.pro.controller.paramDto.out.MenuOutDto;
import com.sobt.pro.dao.bean.TBootstrapSubject;
import com.sobt.pro.vo.SuccessBean;

public interface MenuService {

    public SuccessBean<MenuOutDto.ParentLevelMenuOutDto> parentLevelMenu(MenuInDto.ParentLevelMenuInDto param);

    public SuccessBean<MenuOutDto.MenuDataOutDto> menuData(MenuInDto.MenuDataInDto param);

    public SuccessBean saveMenu(TBootstrapSubject subject);

    public SuccessBean editMenu(TBootstrapSubject subject);

    public SuccessBean deleteMenu(TBootstrapSubject subject);
}
