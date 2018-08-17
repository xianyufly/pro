package com.sobt.pro.controller.paramDto.out;

import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.dao.bean.TBootstrapTag;
import com.sobt.pro.dao.bean.ext.TBootstrapTagExt;
import com.sobt.pro.vo.PageBean;

import java.util.List;

public class BootstrapResOutDto {

    /**
     * 分页查询资源
     */
    public static class GetBootstrapResByPageOutDto extends PageBean {

        private List<TBootstrapRes> dataRows;

        public List<TBootstrapRes> getDataRows() {
            return dataRows;
        }

        public void setDataRows(List<TBootstrapRes> dataRows) {
            this.dataRows = dataRows;
        }

    }

    /**
     * 搜索模板资源
     */
    public static class SearchBootstrapResByParamOutDto extends PageBean  {

        private List<TBootstrapRes> dataRows;

        private List<TBootstrapTagExt> tagList;

        public List<TBootstrapRes> getDataRows() {
            return dataRows;
        }

        public void setDataRows(List<TBootstrapRes> dataRows) {
            this.dataRows = dataRows;
        }

        public List<TBootstrapTagExt> getTagList() {
            return tagList;
        }

        public void setTagList(List<TBootstrapTagExt> tagList) {
            this.tagList = tagList;
        }
    }

    /**
     * 获取Bootstap资源详情
     */
    public static class GetBootstrapResDetailOutDto{

        private TBootstrapRes res;

        private List<TBootstrapTag> tagList;

        private List<TBootstrapRes> aboutRes;

        public TBootstrapRes getRes() {
            return res;
        }

        public void setRes(TBootstrapRes res) {
            this.res = res;
        }

        public List<TBootstrapRes> getAboutRes() {
            return aboutRes;
        }

        public void setAboutRes(List<TBootstrapRes> aboutRes) {
            this.aboutRes = aboutRes;
        }

        public List<TBootstrapTag> getTagList() {
            return tagList;
        }

        public void setTagList(List<TBootstrapTag> tagList) {
            this.tagList = tagList;
        }
    }
}
