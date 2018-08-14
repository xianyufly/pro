package com.sobt.pro.controller.paramDto.out;

import com.sobt.pro.dao.bean.TBootstrapRes;
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
     * 获取Bootstap资源详情
     */
    public static class GetBootstrapResDetailOutDto{

        private TBootstrapRes res;

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
    }
}
