package com.sobt.pro.controller.paramDto.in;

public class UserInDto {

    /**
     * 登陆请求对象
     */
    public static class LoginInDto {

        private String code;

        private String account;

        private String pwd;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
    }

    /**
     * 初始化数据
     */
    public static class InitDataInDto{


    }
}
