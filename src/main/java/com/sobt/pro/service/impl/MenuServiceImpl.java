package com.sobt.pro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.MenuInDto;
import com.sobt.pro.controller.paramDto.out.MenuOutDto;
import com.sobt.pro.dao.TBootstrapSubjectDao;
import com.sobt.pro.dao.bean.TBootstrapSubject;
import com.sobt.pro.dao.bean.TBootstrapSubjectExample;
import com.sobt.pro.service.MenuService;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    TBootstrapSubjectDao subjectDao;


    @Override
    public SuccessBean<MenuOutDto.ParentLevelMenuOutDto> parentLevelMenu(MenuInDto.ParentLevelMenuInDto param) {
        SuccessBean<MenuOutDto.ParentLevelMenuOutDto> result=new SuccessBean<>();
        MenuOutDto.ParentLevelMenuOutDto data=new MenuOutDto.ParentLevelMenuOutDto();
        TBootstrapSubjectExample example=new TBootstrapSubjectExample();
        TBootstrapSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        criteria.andPTidIsNull();
        List<TBootstrapSubject> subjects=subjectDao.selectByExample(example);
        data.setSubjects(subjects);
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean<MenuOutDto.MenuDataOutDto> menuData(MenuInDto.MenuDataInDto param) {
        SuccessBean<MenuOutDto.MenuDataOutDto> result=new SuccessBean<>();
        MenuOutDto.MenuDataOutDto data=new MenuOutDto.MenuDataOutDto();
        PageHelper.startPage(param.getPage(), param.getRows());
        TBootstrapSubjectExample example=new TBootstrapSubjectExample();
        TBootstrapSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        if(param.getpTid()!=null){
            criteria.andPTidEqualTo(param.getpTid());
        }
        if(param.getSubType()!=null){
            criteria.andSubTypeEqualTo(param.getSubType());
        }

        List<TBootstrapSubject> subjects=subjectDao.selectByExample(example);
        PageInfo page = new PageInfo(subjects);
        data.setRows(subjects);
        data.setTotals(page.getTotal());
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean saveMenu(TBootstrapSubject subject) {
        SuccessBean result=new SuccessBean();
        subjectDao.insertSelective(subject);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean editMenu(TBootstrapSubject subject) {
        SuccessBean result=new SuccessBean();
        subjectDao.updateByPrimaryKey(subject);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean deleteMenu(TBootstrapSubject subject) {
        SuccessBean result=new SuccessBean();
        subject.setStatus(1);
        subjectDao.updateByPrimaryKeySelective(subject);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }
}
