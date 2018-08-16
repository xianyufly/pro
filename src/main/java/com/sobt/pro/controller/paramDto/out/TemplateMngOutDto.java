package com.sobt.pro.controller.paramDto.out;

import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.dao.bean.ext.TBootstrapResExt;
import com.sobt.pro.dao.bean.ext.TBootstrapSubjectExt;
import com.sobt.pro.dao.bean.ext.TBootstrapTagExt;

import java.util.List;

public class TemplateMngOutDto {

    /**
     * 模板列表
     */
    public static class TemplateDataOutDto{

        private List<TBootstrapResExt> rows;

        private Long totals;

        public List<TBootstrapResExt> getRows() {
            return rows;
        }

        public void setRows(List<TBootstrapResExt> rows) {
            this.rows = rows;
        }

        public Long getTotals() {
            return totals;
        }

        public void setTotals(Long totals) {
            this.totals = totals;
        }
    }

    public static class MenuListOutDto{
        List<TBootstrapSubjectExt> subjectExts;

        public List<TBootstrapSubjectExt> getSubjectExts() {
            return subjectExts;
        }

        public void setSubjectExts(List<TBootstrapSubjectExt> subjectExts) {
            this.subjectExts = subjectExts;
        }
    }

    public static class TagsListOutDto{

        List<TBootstrapTagExt> tagExts;

        public List<TBootstrapTagExt> getTagExts() {
            return tagExts;
        }

        public void setTagExts(List<TBootstrapTagExt> tagExts) {
            this.tagExts = tagExts;
        }
    }
}
