package com.sobt.pro.dao.func;

import com.sobt.pro.dao.bean.TArticle;
import com.sobt.pro.dao.bean.TArticleExample.Criteria;
import com.sobt.pro.dao.bean.TArticleExample.Criterion;
import com.sobt.pro.dao.bean.TArticleExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class TArticleSqlProvider {

    public String insertSelective(TArticle record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_article");
        
        if (record.getArtType() != null) {
            sql.VALUES("art_type", "#{artType,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getMemo() != null) {
            sql.VALUES("memo", "#{memo,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceUrl() != null) {
            sql.VALUES("source_url", "#{sourceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getSmallPic() != null) {
            sql.VALUES("small_pic", "#{smallPic,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            sql.VALUES("source", "#{source,jdbcType=VARCHAR}");
        }
        
        if (record.getPubDate() != null) {
            sql.VALUES("pub_date", "#{pubDate,jdbcType=DATE}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getDirKey() != null) {
            sql.VALUES("dir_key", "#{dirKey,jdbcType=VARCHAR}");
        }
        
        if (record.getpDirKey() != null) {
            sql.VALUES("p_dir_key", "#{pDirKey,jdbcType=VARCHAR}");
        }
        
        if (record.getDirName() != null) {
            sql.VALUES("dir_name", "#{dirName,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(TArticleExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("tid");
        } else {
            sql.SELECT("tid");
        }
        sql.SELECT("art_type");
        sql.SELECT("title");
        sql.SELECT("memo");
        sql.SELECT("source_url");
        sql.SELECT("small_pic");
        sql.SELECT("source");
        sql.SELECT("pub_date");
        sql.SELECT("status");
        sql.SELECT("dir_key");
        sql.SELECT("p_dir_key");
        sql.SELECT("dir_name");
        sql.SELECT("content");
        sql.FROM("t_article");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(TArticleExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("tid");
        } else {
            sql.SELECT("tid");
        }
        sql.SELECT("art_type");
        sql.SELECT("title");
        sql.SELECT("memo");
        sql.SELECT("source_url");
        sql.SELECT("small_pic");
        sql.SELECT("source");
        sql.SELECT("pub_date");
        sql.SELECT("status");
        sql.SELECT("dir_key");
        sql.SELECT("p_dir_key");
        sql.SELECT("dir_name");
        sql.FROM("t_article");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TArticle record) {
        SQL sql = new SQL();
        sql.UPDATE("t_article");
        
        if (record.getArtType() != null) {
            sql.SET("art_type = #{artType,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getMemo() != null) {
            sql.SET("memo = #{memo,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceUrl() != null) {
            sql.SET("source_url = #{sourceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getSmallPic() != null) {
            sql.SET("small_pic = #{smallPic,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            sql.SET("source = #{source,jdbcType=VARCHAR}");
        }
        
        if (record.getPubDate() != null) {
            sql.SET("pub_date = #{pubDate,jdbcType=DATE}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getDirKey() != null) {
            sql.SET("dir_key = #{dirKey,jdbcType=VARCHAR}");
        }
        
        if (record.getpDirKey() != null) {
            sql.SET("p_dir_key = #{pDirKey,jdbcType=VARCHAR}");
        }
        
        if (record.getDirName() != null) {
            sql.SET("dir_name = #{dirName,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("tid = #{tid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TArticleExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}