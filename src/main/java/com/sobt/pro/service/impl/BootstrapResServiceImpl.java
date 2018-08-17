package com.sobt.pro.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.constant.SatusEnum;
import com.sobt.pro.controller.paramDto.in.BootstrapResInDto;
import com.sobt.pro.controller.paramDto.out.BootstrapResOutDto;
import com.sobt.pro.dao.TBootResTagDao;
import com.sobt.pro.dao.TBootstrapResDao;
import com.sobt.pro.dao.TBootstrapTagDao;
import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.dao.bean.TBootstrapResExample;
import com.sobt.pro.dao.bean.TBootstrapTag;
import com.sobt.pro.dao.bean.TBootstrapTagExample;
import com.sobt.pro.dao.bean.ext.TBootstrapTagExt;
import com.sobt.pro.service.BootstrapResService;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BootstrapResServiceImpl implements BootstrapResService {

    @Resource
    TBootstrapResDao btDao;
    @Resource
    TBootResTagDao resTagDao;
    @Resource
    TBootstrapTagDao tagDao;


    @Override
    public SuccessBean<BootstrapResOutDto.GetBootstrapResByPageOutDto> getBootstrapResByPage(BootstrapResInDto.GetBootstrapResByPageInDto param) {
        SuccessBean<BootstrapResOutDto.GetBootstrapResByPageOutDto> result=new SuccessBean<>();

        BootstrapResOutDto.GetBootstrapResByPageOutDto data=new BootstrapResOutDto.GetBootstrapResByPageOutDto();
        PageHelper.startPage(param.getPage(), param.getRows());
        TBootstrapResExample example=new TBootstrapResExample();
        TBootstrapResExample.Criteria c=example.createCriteria();
        c.andStatusEqualTo(SatusEnum.Normal.getCode());
        example.setOrderByClause("tid desc");
        List<TBootstrapRes> dataRows=btDao.selectByExample(example);
        PageInfo page = new PageInfo(dataRows);
        data.setDataRows(dataRows);
        data.setTotals(page.getTotal());
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean<BootstrapResOutDto.SearchBootstrapResByParamOutDto> searchBootstrapResByParam(BootstrapResInDto.SearchBootstrapResByParamInDto param) {
        SuccessBean<BootstrapResOutDto.SearchBootstrapResByParamOutDto> result=new SuccessBean<>();
        BootstrapResOutDto.SearchBootstrapResByParamOutDto data=new BootstrapResOutDto.SearchBootstrapResByParamOutDto();
        //处理filter字段
        String filter=param.getFilter();
        List<List<Integer>> tagIds=new ArrayList<>();
        Map<String,List<Integer>> zmGroup=new HashMap<>();
        Map<String,Object> tempParam=new HashMap<>();
        if(!StringUtil.isEmpty(filter)){
            String[] temp=filter.split("\\-");
            for(String t:temp){
                //
                String key=t.substring(0,1);
                if(zmGroup.get(key)==null){
                    zmGroup.put(key,new ArrayList<Integer>());
                }
                try{
                    List<Integer> arr=zmGroup.get(key);
                    Integer id=Integer.parseInt(t.substring(1));
                    arr.add(id);
                }catch (Exception e){
                }
            }
            for (Map.Entry<String,List<Integer>> entry : zmGroup.entrySet()) {
                List<Integer> t=entry.getValue();
                if(t.size()>0){
                    tagIds.add(t);
                }
            }
            tempParam.put("tagIds",tagIds);
        }
        PageHelper.startPage(param.getPage(), param.getRows());
        List<TBootstrapRes> dataRows=btDao.selectRandomResByTags(tempParam);
        PageInfo page = new PageInfo(dataRows);
        data.setDataRows(dataRows);
        data.setTotals(page.getTotal());
        result.setData(data);
        //查询tag数据
        TBootstrapTagExample subjectExample=new TBootstrapTagExample();
        TBootstrapTagExample.Criteria subC=subjectExample.createCriteria();
        subC.andStatusEqualTo(SatusEnum.Normal.getCode());
        subC.andPTidIsNull();
        List<TBootstrapTag> subjects=tagDao.selectByExample(subjectExample);
        List<TBootstrapTagExt> exts=new ArrayList<>();
        for(TBootstrapTag subject:subjects){
            String temp_s= JSONObject.toJSONString(subject);
            TBootstrapTagExt ext=JSONObject.parseObject(temp_s,TBootstrapTagExt.class);
            subjectExample=new TBootstrapTagExample();
            TBootstrapTagExample.Criteria temp=subjectExample.createCriteria();
            temp.andStatusEqualTo(SatusEnum.Normal.getCode());
            temp.andPTidEqualTo(subject.getTid());
            List<TBootstrapTag> children=tagDao.selectByExample(subjectExample);
            ext.setChildren(children);
            exts.add(ext);
        }
        data.setTagList(exts);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean<BootstrapResOutDto.GetBootstrapResDetailOutDto> getBootstrapResDetail(BootstrapResInDto.GetBootstrapResDetailInDto param) {
        SuccessBean<BootstrapResOutDto.GetBootstrapResDetailOutDto> result=new SuccessBean<>();
        BootstrapResOutDto.GetBootstrapResDetailOutDto data=new BootstrapResOutDto.GetBootstrapResDetailOutDto();
        TBootstrapResExample example=new TBootstrapResExample();
        TBootstrapResExample.Criteria c=example.createCriteria();
        c.andDirNameEqualTo(param.getDirName());
        List<TBootstrapRes> resList=btDao.selectByExample(example);
        TBootstrapRes res=resList.get(0);
        data.setRes(res);
        //查询模板标签
        List<TBootstrapTag> tagList=resTagDao.getTagByResId(res.getTid());
        data.setTagList(tagList);
        Map<String,Object> tempParam=new HashMap<>();
        tempParam.put("tid",res.getTid());
        resList=btDao.selectRandomRes(tempParam);
        data.setAboutRes(resList);
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }
}
