package com.sobt.pro.service;

import com.sobt.pro.controller.paramDto.in.TemplateMngInDto;
import com.sobt.pro.controller.paramDto.out.TemplateMngOutDto;
import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.vo.SuccessBean;

public interface TemplateMngService {

    public SuccessBean<TemplateMngOutDto.TemplateDataOutDto> templateData(TemplateMngInDto.TemplateDataInDto param);

    public SuccessBean editTemplate(TemplateMngInDto.EditTemplateInDto param);

    public SuccessBean deleteTemplate(TBootstrapRes param);

    public SuccessBean<TemplateMngOutDto.MenuListOutDto> menuList(TemplateMngInDto.MenuListInDto param);

    public SuccessBean<TemplateMngOutDto.TagsListOutDto> tagList(TemplateMngInDto.TagsListInDto param);
}
