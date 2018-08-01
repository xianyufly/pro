package com.sobt.pro.controller.paramDto.in;

import com.sobt.pro.vo.PageBean;
import org.hibernate.validator.constraints.NotBlank;


public class ArticleInDto {

    /**
     * 文章分页入参类
     */
    public static class GetArticleByPageInDto extends PageBean {

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

    /**
     * 获取文章详情
     */
    public static class  GetArticleDetailInDto {
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
