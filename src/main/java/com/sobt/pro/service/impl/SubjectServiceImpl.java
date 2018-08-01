package com.sobt.pro.service.impl;

import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.SubjectInDto;
import com.sobt.pro.controller.paramDto.out.SubjectOutDto;
import com.sobt.pro.dao.TSubjectDao;
import com.sobt.pro.dao.bean.TSubject;
import com.sobt.pro.dao.bean.TSubjectExample;
import com.sobt.pro.service.SubjectService;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    TSubjectDao subjectDao;

    @Override
    public SuccessBean<SubjectOutDto.GetSubjectListOutDto> getSubjectList(SubjectInDto param) {
        SuccessBean<SubjectOutDto.GetSubjectListOutDto> successBean=new SuccessBean<>();
        TSubjectExample example=new TSubjectExample();
        TSubjectExample.Criteria c=example.createCriteria();
        c.andSubStatusEqualTo(0);
        List<TSubject> subjects=subjectDao.selectByExample(example);
        SubjectOutDto.GetSubjectListOutDto data=new SubjectOutDto.GetSubjectListOutDto();
        data.setSubjects(subjects);
        successBean.setData(data);
        successBean.setError(MsgEnum.Success.getCode());
        successBean.setDesc(MsgEnum.Success.getMsg());
        return successBean;
    }
}
