package com.sobt.pro.service;

import com.sobt.pro.controller.paramDto.in.SubjectInDto;
import com.sobt.pro.controller.paramDto.out.SubjectOutDto;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.validation.BindingResult;

public interface SubjectService {

    /**
     * 获取菜单列表
     * @param param
     * @return
     */
    public SuccessBean<SubjectOutDto.GetSubjectListOutDto> getSubjectList(SubjectInDto param);
}
