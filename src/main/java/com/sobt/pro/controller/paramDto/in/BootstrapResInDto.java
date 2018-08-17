package com.sobt.pro.controller.paramDto.in;

import com.sobt.pro.vo.PageBean;
import org.hibernate.validator.constraints.NotBlank;

public class BootstrapResInDto {

    public static class GetBootstrapResByPageInDto extends PageBean {

        private String searchVal;

        private String subject;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getSearchVal() {
            return searchVal;
        }

        public void setSearchVal(String searchVal) {
            this.searchVal = searchVal;
        }
    }

    public static class SearchBootstrapResByParamInDto extends PageBean {
        private String filter;

        private String subject;

        public String getFilter() {
            return filter;
        }

        public void setFilter(String filter) {
            this.filter = filter;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }
    }

    /**
     * 获取文章详情
     */
    public static class  GetBootstrapResDetailInDto {
        //文章唯一标识
        @NotBlank(message = "dirName不能为空")
        private String dirName;

        public String getDirName() {
            return dirName;
        }

        public void setDirName(String dirName) {
            this.dirName = dirName;
        }
    }
}
