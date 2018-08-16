package com.sobt.pro.controller.paramDto.out;

import com.sobt.pro.dao.bean.TBootstrapSubject;
import com.sobt.pro.dao.bean.TBootstrapTag;

import java.util.List;

public class TagsOutDto {

    /**
     * 一级菜单
     */
    public static class ParentLevelTagsOutDto{
        private List<TBootstrapTag> subjects;

        public List<TBootstrapTag> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<TBootstrapTag> subjects) {
            this.subjects = subjects;
        }
    }

    /**
     * 菜单列表查询
     */
    public static class TagsDataOutDto {

        private Long totals;

        private List<TBootstrapTag> rows;

        public Long getTotals() {
            return totals;
        }

        public void setTotals(Long totals) {
            this.totals = totals;
        }

        public List<TBootstrapTag> getRows() {
            return rows;
        }

        public void setRows(List<TBootstrapTag> rows) {
            this.rows = rows;
        }
    }

}
