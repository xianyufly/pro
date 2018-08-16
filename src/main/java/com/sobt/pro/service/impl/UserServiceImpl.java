package com.sobt.pro.service.impl;

import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.UserInDto;
import com.sobt.pro.controller.paramDto.out.UserOutDto;
import com.sobt.pro.dao.TBootstrapSubjectDao;
import com.sobt.pro.dao.TUserDao;
import com.sobt.pro.dao.bean.TBootstrapSubject;
import com.sobt.pro.dao.bean.TBootstrapSubjectExample;
import com.sobt.pro.dao.bean.TUser;
import com.sobt.pro.dao.bean.TUserExample;
import com.sobt.pro.service.UserService;
import com.sobt.pro.util.CommUtil;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    TUserDao userDao;
    @Resource
    TBootstrapSubjectDao bootstrapSubjectDao;
    @Resource
    HttpSession session;


    @Override
    public SuccessBean<UserOutDto.LoginOutDto> login(UserInDto.LoginInDto param) {
        SuccessBean<UserOutDto.LoginOutDto> result=new SuccessBean<>();
        UserOutDto.LoginOutDto data=new UserOutDto.LoginOutDto();
        //对比验证码
        String session_code=(String) session.getAttribute("code");
        if(!param.getCode().equals(session_code)){
            result.setError(MsgEnum.Error.getCode());
            result.setDesc("验证码错误");
            return result;
        }
        //查询账号
        TUserExample example=new TUserExample();
        TUserExample.Criteria cri=example.createCriteria();
        cri.andAccountEqualTo(param.getAccount());
        String pwd= CommUtil.hash(param.getPwd());
        cri.andPwdEqualTo(pwd);
        List<TUser> users=userDao.selectByExample(example);
        if(users.size()!=1){
            result.setError(MsgEnum.Error.getCode());
            result.setDesc("账号或者密码错误");
            return result;
        }else{
            TUser user=users.get(0);
            session.setAttribute("user",user);
            data.setUser(user);
            //查询菜单
            TBootstrapSubjectExample subjectExample=new TBootstrapSubjectExample();
            TBootstrapSubjectExample.Criteria subjectC=subjectExample.createCriteria();
            subjectC.andStatusEqualTo(0);
            subjectC.andSubTypeEqualTo(0);
            subjectExample.setOrderByClause("sort desc");
            List<TBootstrapSubject> subjects=bootstrapSubjectDao.selectByExample(subjectExample);
            data.setSubjects(subjects);
            result.setError(MsgEnum.Success.getCode());
            result.setDesc(MsgEnum.Success.getMsg());
            result.setData(data);
        }
        return result;
    }

    @Override
    public SuccessBean<UserOutDto.InitDataOutDto> initData(UserInDto.InitDataInDto param) {
        SuccessBean<UserOutDto.InitDataOutDto> result=new SuccessBean<>();
        UserOutDto.InitDataOutDto data=new UserOutDto.InitDataOutDto();
        TUser user=(TUser)session.getAttribute("user");
        data.setUser(user);
        //查询菜单
        TBootstrapSubjectExample subjectExample=new TBootstrapSubjectExample();
        TBootstrapSubjectExample.Criteria subjectC=subjectExample.createCriteria();
        subjectC.andStatusEqualTo(0);
        subjectC.andSubTypeEqualTo(0);
        subjectExample.setOrderByClause("sort desc");
        List<TBootstrapSubject> subjects=bootstrapSubjectDao.selectByExample(subjectExample);
        data.setSubjects(subjects);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        result.setData(data);
        return result;
    }
}
