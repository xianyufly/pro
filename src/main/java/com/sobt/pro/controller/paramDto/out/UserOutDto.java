package com.sobt.pro.controller.paramDto.out;

import com.sobt.pro.dao.bean.TBootstrapSubject;
import com.sobt.pro.dao.bean.TUser;

import java.util.List;

public class UserOutDto {

    /**
     * 登陆返回对象
     */
    public static class LoginOutDto {

        private TUser user;

        private List<TBootstrapSubject> subjects;

        public List<TBootstrapSubject> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<TBootstrapSubject> subjects) {
            this.subjects = subjects;
        }

        public TUser getUser() {
            return user;
        }

        public void setUser(TUser user) {
            this.user = user;
        }
    }

    /**
     * 初始化数据
     */
    public static class InitDataOutDto{

        private TUser user;

        private List<TBootstrapSubject> subjects;

        public List<TBootstrapSubject> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<TBootstrapSubject> subjects) {
            this.subjects = subjects;
        }

        public TUser getUser() {
            return user;
        }

        public void setUser(TUser user) {
            this.user = user;
        }
    }


}
