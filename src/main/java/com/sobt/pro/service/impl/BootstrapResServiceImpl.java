package com.sobt.pro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.constant.SatusEnum;
import com.sobt.pro.controller.paramDto.in.BootstrapResInDto;
import com.sobt.pro.controller.paramDto.out.BootstrapResOutDto;
import com.sobt.pro.dao.TBootstrapResDao;
import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.dao.bean.TBootstrapResExample;
import com.sobt.pro.service.BootstrapResService;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BootstrapResServiceImpl implements BootstrapResService {

    @Resource
    TBootstrapResDao btDao;


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
    public SuccessBean<BootstrapResOutDto.GetBootstrapResDetailOutDto> getBootstrapResDetail(BootstrapResInDto.GetBootstrapResDetailInDto param) {
        SuccessBean<BootstrapResOutDto.GetBootstrapResDetailOutDto> result=new SuccessBean<>();
        BootstrapResOutDto.GetBootstrapResDetailOutDto data=new BootstrapResOutDto.GetBootstrapResDetailOutDto();
        TBootstrapResExample example=new TBootstrapResExample();
        TBootstrapResExample.Criteria c=example.createCriteria();
        c.andDirNameEqualTo(param.getDirName());
        List<TBootstrapRes> resList=btDao.selectByExample(example);
        TBootstrapRes res=resList.get(0);
        data.setRes(res);
        Map<String,Object> tempParam=new HashMap<>();
        tempParam.put("tid",res.getTid());
//        tempParam.put("artType",article.getArtType());
        resList=btDao.selectRandomRes(tempParam);
        data.setAboutRes(resList);
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }
}
