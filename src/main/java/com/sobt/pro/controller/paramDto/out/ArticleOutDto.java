package com.sobt.pro.controller.paramDto.out;

import com.sobt.pro.dao.bean.TArticle;
import com.sobt.pro.vo.PageBean;

import java.util.List;

public class ArticleOutDto {

    /**
     * 文章分页结果
     */
    public static class GetArticleByPageOutDto extends PageBean {

        private List<TArticle> dataRows;

        public List<TArticle> getDataRows() {
            return dataRows;
        }

        public void setDataRows(List<TArticle> dataRows) {
            this.dataRows = dataRows;
        }
    }

    /**
     * 文章详情结果
     */
    public static class GetArticleDetailOutDto {

        private TArticle article;

        private List<TArticle> aboutArticle;

        public TArticle getArticle() {
            return article;
        }

        public void setArticle(TArticle article) {
            this.article = article;
        }

        public List<TArticle> getAboutArticle() {
            return aboutArticle;
        }

        public void setAboutArticle(List<TArticle> aboutArticle) {
            this.aboutArticle = aboutArticle;
        }
    }
}
