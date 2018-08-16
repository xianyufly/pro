package com.sobt.pro.controller.paramDto.in;

import com.sobt.pro.dao.bean.TBootResTag;
import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.vo.PageBean;

import java.util.List;

public class TemplateMngInDto {

    public static class TemplateDataInDto extends PageBean{

        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class EditTemplateInDto {

        private TBootstrapRes res;

        private List<TBootResTag> relas;

        public TBootstrapRes getRes() {
            return res;
        }

        public void setRes(TBootstrapRes res) {
            this.res = res;
        }

        public List<TBootResTag> getRelas() {
            return relas;
        }

        public void setRelas(List<TBootResTag> relas) {
            this.relas = relas;
        }
    }

    public static class MenuListInDto{

        private Integer subType;

        public Integer getSubType() {
            return subType;
        }

        public void setSubType(Integer subType) {
            this.subType = subType;
        }
    }

    public static class TagsListInDto{

    }

}
