package com.sobt.pro.controller.paramDto.out;

import com.sobt.pro.dao.bean.TBootstrapSubject;
import com.sobt.pro.vo.PageBean;

import java.util.List;

public class MenuOutDto {

    /**
     * 一级菜单
     */
    public static class ParentLevelMenuOutDto{
        private List<TBootstrapSubject> subjects;

        public List<TBootstrapSubject> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<TBootstrapSubject> subjects) {
            this.subjects = subjects;
        }
    }

    /**
     * 菜单列表查询
     */
    public static class MenuDataOutDto {

        private Long totals;

        private List<TBootstrapSubject> rows;

        public Long getTotals() {
            return totals;
        }

        public void setTotals(Long totals) {
            this.totals = totals;
        }

        public List<TBootstrapSubject> getRows() {
            return rows;
        }

        public void setRows(List<TBootstrapSubject> rows) {
            this.rows = rows;
        }
    }

}
