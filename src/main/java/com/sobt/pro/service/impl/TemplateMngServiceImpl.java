package com.sobt.pro.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.constant.SatusEnum;
import com.sobt.pro.controller.paramDto.in.TemplateMngInDto;
import com.sobt.pro.controller.paramDto.out.TemplateMngOutDto;
import com.sobt.pro.dao.TBootResTagDao;
import com.sobt.pro.dao.TBootstrapResDao;
import com.sobt.pro.dao.TBootstrapSubjectDao;
import com.sobt.pro.dao.TBootstrapTagDao;
import com.sobt.pro.dao.bean.*;
import com.sobt.pro.dao.bean.ext.TBootstrapResExt;
import com.sobt.pro.dao.bean.ext.TBootstrapSubjectExt;
import com.sobt.pro.dao.bean.ext.TBootstrapTagExt;
import com.sobt.pro.service.TemplateMngService;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateMngServiceImpl implements TemplateMngService {

    @Resource
    TBootstrapTagDao tagDao;

    @Resource
    TBootResTagDao resTagDao;

    @Resource
    TBootstrapResDao resDao;

    @Resource
    TBootstrapSubjectDao subjectDao;


    @Override
    public SuccessBean<TemplateMngOutDto.TemplateDataOutDto> templateData(TemplateMngInDto.TemplateDataInDto param) {
        SuccessBean<TemplateMngOutDto.TemplateDataOutDto> result=new SuccessBean<>();
        TemplateMngOutDto.TemplateDataOutDto data=new TemplateMngOutDto.TemplateDataOutDto();
        PageHelper.startPage(param.getPage(), param.getRows());
        TBootstrapResExample example=new TBootstrapResExample();
        TBootstrapResExample.Criteria c=example.createCriteria();
        if(!StringUtil.isEmpty(param.getTitle())){
            c.andTitleLike("%"+param.getTitle()+"%");
        }
        c.andStatusEqualTo(SatusEnum.Normal.getCode());
        example.setOrderByClause("tid desc");
        List<TBootstrapRes> rows_temp=resDao.selectByExample(example);
        PageInfo page = new PageInfo(rows_temp);
        List<TBootstrapResExt> dataRows=new ArrayList<>();
        for(TBootstrapRes res:rows_temp){
            String temp_s=JSONObject.toJSONString(res);
            TBootstrapResExt ext=JSONObject.parseObject(temp_s,TBootstrapResExt.class);
            if(res.getSubjectCode()!=null){
                TBootstrapSubjectExample subjectExample=new TBootstrapSubjectExample();
                TBootstrapSubjectExample.Criteria suc=subjectExample.createCriteria();
                suc.andCodeEqualTo(res.getSubjectCode());
                List<TBootstrapSubject> subjects=subjectDao.selectByExample(subjectExample);
                TBootstrapSubject subject=subjects.get(0);
                ext.setSubjectName(subject.getText());
            }
            //查询标签列表
            List<Integer> tagList=resTagDao.getTagIdByResId(res.getTid());
            ext.setTagList(tagList);
            dataRows.add(ext);
        }
        data.setRows(dataRows);
        data.setTotals(page.getTotal());
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean editTemplate(TemplateMngInDto.EditTemplateInDto param) {
        SuccessBean result=new SuccessBean();
        TBootstrapRes res=param.getRes();
        resDao.updateByPrimaryKeySelective(res);
        //先删除标签关系表
        resTagDao.deleteByResId(res.getTid());
        List<TBootResTag> relas=param.getRelas();
        for(TBootResTag rela:relas){
            resTagDao.insertSelective(rela);
        }
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean deleteTemplate(TBootstrapRes param) {
        SuccessBean result=new SuccessBean();
        param.setStatus(SatusEnum.Delete.getCode());
        resDao.updateByPrimaryKeySelective(param);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean<TemplateMngOutDto.MenuListOutDto> menuList(TemplateMngInDto.MenuListInDto param) {
        SuccessBean<TemplateMngOutDto.MenuListOutDto> result=new SuccessBean<>();
        TemplateMngOutDto.MenuListOutDto data=new TemplateMngOutDto.MenuListOutDto();
        TBootstrapSubjectExample subjectExample=new TBootstrapSubjectExample();
        TBootstrapSubjectExample.Criteria subC=subjectExample.createCriteria();
        subC.andStatusEqualTo(SatusEnum.Normal.getCode());
        if(param.getSubType()!=null){
            subC.andSubTypeEqualTo(param.getSubType());
        }
        subC.andPTidIsNull();
        List<TBootstrapSubject> subjects=subjectDao.selectByExample(subjectExample);
        List<TBootstrapSubjectExt> exts=new ArrayList<>();
        for(TBootstrapSubject subject:subjects){
            String temp_s=JSONObject.toJSONString(subject);
            TBootstrapSubjectExt ext=JSONObject.parseObject(temp_s,TBootstrapSubjectExt.class);
            subjectExample=new TBootstrapSubjectExample();
            TBootstrapSubjectExample.Criteria temp=subjectExample.createCriteria();
            temp.andStatusEqualTo(SatusEnum.Normal.getCode());
            temp.andPTidEqualTo(subject.getTid());
            if(param.getSubType()!=null){
                temp.andSubTypeEqualTo(param.getSubType());
            }
            List<TBootstrapSubject> children=subjectDao.selectByExample(subjectExample);
            ext.setChildren(children);
            exts.add(ext);
        }
        data.setSubjectExts(exts);
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean<TemplateMngOutDto.TagsListOutDto> tagList(TemplateMngInDto.TagsListInDto param) {
        SuccessBean<TemplateMngOutDto.TagsListOutDto> result=new SuccessBean<>();
        TemplateMngOutDto.TagsListOutDto data=new TemplateMngOutDto.TagsListOutDto();
        TBootstrapTagExample subjectExample=new TBootstrapTagExample();
        TBootstrapTagExample.Criteria subC=subjectExample.createCriteria();
        subC.andStatusEqualTo(SatusEnum.Normal.getCode());
        subC.andPTidIsNull();
        List<TBootstrapTag> subjects=tagDao.selectByExample(subjectExample);
        List<TBootstrapTagExt> exts=new ArrayList<>();
        for(TBootstrapTag subject:subjects){
            String temp_s=JSONObject.toJSONString(subject);
            TBootstrapTagExt ext=JSONObject.parseObject(temp_s,TBootstrapTagExt.class);
            subjectExample=new TBootstrapTagExample();
            TBootstrapTagExample.Criteria temp=subjectExample.createCriteria();
            temp.andStatusEqualTo(SatusEnum.Normal.getCode());
            temp.andPTidEqualTo(subject.getTid());
            List<TBootstrapTag> children=tagDao.selectByExample(subjectExample);
            ext.setChildren(children);
            exts.add(ext);
        }
        data.setTagExts(exts);
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }
}
