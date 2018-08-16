package com.sobt.pro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.TagsInDto;
import com.sobt.pro.controller.paramDto.out.TagsOutDto;
import com.sobt.pro.dao.TBootstrapTagDao;
import com.sobt.pro.dao.bean.TBootstrapTag;
import com.sobt.pro.dao.bean.TBootstrapTagExample;
import com.sobt.pro.service.TagsService;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {

    @Resource
    TBootstrapTagDao tagDao;

    @Override
    public SuccessBean<TagsOutDto.ParentLevelTagsOutDto> parentLevelTags(TagsInDto.ParentLevelTagsInDto param) {
        SuccessBean<TagsOutDto.ParentLevelTagsOutDto> result=new SuccessBean<>();
        TagsOutDto.ParentLevelTagsOutDto data=new TagsOutDto.ParentLevelTagsOutDto();
        TBootstrapTagExample example=new TBootstrapTagExample();
        TBootstrapTagExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        criteria.andPTidIsNull();
        List<TBootstrapTag> subjects=tagDao.selectByExample(example);
        data.setSubjects(subjects);
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean<TagsOutDto.TagsDataOutDto> TagsData(TagsInDto.TagsDataInDto param) {
        SuccessBean<TagsOutDto.TagsDataOutDto> result=new SuccessBean<>();
        TagsOutDto.TagsDataOutDto data=new TagsOutDto.TagsDataOutDto();
        PageHelper.startPage(param.getPage(), param.getRows());
        TBootstrapTagExample example=new TBootstrapTagExample();
        TBootstrapTagExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        if(param.getpTid()!=null){
            criteria.andPTidEqualTo(param.getpTid());
        }

        List<TBootstrapTag> subjects=tagDao.selectByExample(example);
        PageInfo page = new PageInfo(subjects);
        data.setRows(subjects);
        data.setTotals(page.getTotal());
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean saveTags(TBootstrapTag tag) {
        SuccessBean result=new SuccessBean();
        tagDao.insertSelective(tag);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean editTags(TBootstrapTag tag) {
        SuccessBean result=new SuccessBean();
        tagDao.updateByPrimaryKey(tag);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean deleteTags(TBootstrapTag tag) {
        SuccessBean result=new SuccessBean();
        tag.setStatus(1);
        tagDao.updateByPrimaryKeySelective(tag);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }
}
