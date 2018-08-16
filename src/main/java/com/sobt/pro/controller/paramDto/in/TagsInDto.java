package com.sobt.pro.controller.paramDto.in;

import com.sobt.pro.vo.PageBean;

public class TagsInDto {

    /**
     * 一级菜单
     */
    public static class ParentLevelTagsInDto{

    }

    /**
     * 菜单列表查询
     */
    public static class TagsDataInDto extends PageBean {

        private Integer pTid;

        private Integer subType;

        public Integer getpTid() {
            return pTid;
        }

        public void setpTid(Integer pTid) {
            this.pTid = pTid;
        }

        public Integer getSubType() {
            return subType;
        }

        public void setSubType(Integer subType) {
            this.subType = subType;
        }
    }
}
