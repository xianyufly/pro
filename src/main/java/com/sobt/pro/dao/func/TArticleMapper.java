package com.sobt.pro.dao.func;

import com.sobt.pro.dao.bean.TArticle;
import com.sobt.pro.dao.bean.TArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TArticleMapper {
    @Delete({
        "delete from t_article",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tid);

    @Insert({
        "insert into t_article (art_type, title, ",
        "memo, source_url, ",
        "small_pic, source, ",
        "pub_date, status, dir_key, ",
        "p_dir_key, dir_name, ",
        "content)",
        "values (#{artType,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{memo,jdbcType=VARCHAR}, #{sourceUrl,jdbcType=VARCHAR}, ",
        "#{smallPic,jdbcType=VARCHAR}, #{source,jdbcType=VARCHAR}, ",
        "#{pubDate,jdbcType=DATE}, #{status,jdbcType=INTEGER}, #{dirKey,jdbcType=VARCHAR}, ",
        "#{pDirKey,jdbcType=VARCHAR}, #{dirName,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insert(TArticle record);

    @InsertProvider(type=TArticleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insertSelective(TArticle record);

    @SelectProvider(type=TArticleSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="art_type", property="artType", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_url", property="sourceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="small_pic", property="smallPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="pub_date", property="pubDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="dir_key", property="dirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_dir_key", property="pDirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="dir_name", property="dirName", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TArticle> selectByExampleWithBLOBs(TArticleExample example);

    @SelectProvider(type=TArticleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="art_type", property="artType", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_url", property="sourceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="small_pic", property="smallPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="pub_date", property="pubDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="dir_key", property="dirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_dir_key", property="pDirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="dir_name", property="dirName", jdbcType=JdbcType.VARCHAR)
    })
    List<TArticle> selectByExample(TArticleExample example);

    @Select({
        "select",
        "tid, art_type, title, memo, source_url, small_pic, source, pub_date, status, ",
        "dir_key, p_dir_key, dir_name, content",
        "from t_article",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="art_type", property="artType", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_url", property="sourceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="small_pic", property="smallPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="pub_date", property="pubDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="dir_key", property="dirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_dir_key", property="pDirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="dir_name", property="dirName", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    TArticle selectByPrimaryKey(Integer tid);

    @UpdateProvider(type=TArticleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TArticle record);

    @Update({
        "update t_article",
        "set art_type = #{artType,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "memo = #{memo,jdbcType=VARCHAR},",
          "source_url = #{sourceUrl,jdbcType=VARCHAR},",
          "small_pic = #{smallPic,jdbcType=VARCHAR},",
          "source = #{source,jdbcType=VARCHAR},",
          "pub_date = #{pubDate,jdbcType=DATE},",
          "status = #{status,jdbcType=INTEGER},",
          "dir_key = #{dirKey,jdbcType=VARCHAR},",
          "p_dir_key = #{pDirKey,jdbcType=VARCHAR},",
          "dir_name = #{dirName,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(TArticle record);

    @Update({
        "update t_article",
        "set art_type = #{artType,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "memo = #{memo,jdbcType=VARCHAR},",
          "source_url = #{sourceUrl,jdbcType=VARCHAR},",
          "small_pic = #{smallPic,jdbcType=VARCHAR},",
          "source = #{source,jdbcType=VARCHAR},",
          "pub_date = #{pubDate,jdbcType=DATE},",
          "status = #{status,jdbcType=INTEGER},",
          "dir_key = #{dirKey,jdbcType=VARCHAR},",
          "p_dir_key = #{pDirKey,jdbcType=VARCHAR},",
          "dir_name = #{dirName,jdbcType=VARCHAR}",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TArticle record);
}