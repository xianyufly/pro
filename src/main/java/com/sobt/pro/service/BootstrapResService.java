package com.sobt.pro.service;

import com.sobt.pro.controller.paramDto.in.ArticleInDto;
import com.sobt.pro.controller.paramDto.in.BootstrapResInDto;
import com.sobt.pro.controller.paramDto.out.ArticleOutDto;
import com.sobt.pro.controller.paramDto.out.BootstrapResOutDto;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface BootstrapResService {
    /**
     * 分页查询模板资源
     * @param param
     * @return
     */
    public SuccessBean<BootstrapResOutDto.GetBootstrapResByPageOutDto> getBootstrapResByPage(BootstrapResInDto.GetBootstrapResByPageInDto param);

    /**
     * 查询模板资源
     * @param param
     * @return
     */
    public SuccessBean<BootstrapResOutDto.SearchBootstrapResByParamOutDto> searchBootstrapResByParam (BootstrapResInDto.SearchBootstrapResByParamInDto param);

    /**
     * 获取模板内容
     * @param param
     * @return
     */
    public SuccessBean<BootstrapResOutDto.GetBootstrapResDetailOutDto> getBootstrapResDetail(BootstrapResInDto.GetBootstrapResDetailInDto param);
}
