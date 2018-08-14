package com.sobt.pro.dao.func;

import com.sobt.pro.dao.bean.TBootstrapRes;
import com.sobt.pro.dao.bean.TBootstrapResExample;
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

public interface TBootstrapResMapper {
    @Delete({
        "delete from t_bootstrap_res",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tid);

    @Insert({
        "insert into t_bootstrap_res (title, memo, ",
        "code, face_url, view_url, ",
        "dir_key, p_dir_key, ",
        "dir_name, qq, status, ",
        "download_num, view_num, ",
        "file_id)",
        "values (#{title,jdbcType=VARCHAR}, #{memo,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{faceUrl,jdbcType=VARCHAR}, #{viewUrl,jdbcType=VARCHAR}, ",
        "#{dirKey,jdbcType=VARCHAR}, #{pDirKey,jdbcType=VARCHAR}, ",
        "#{dirName,jdbcType=VARCHAR}, #{qq,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{downloadNum,jdbcType=INTEGER}, #{viewNum,jdbcType=INTEGER}, ",
        "#{fileId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insert(TBootstrapRes record);

    @InsertProvider(type=TBootstrapResSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insertSelective(TBootstrapRes record);

    @SelectProvider(type=TBootstrapResSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="face_url", property="faceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="view_url", property="viewUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="dir_key", property="dirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_dir_key", property="pDirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="dir_name", property="dirName", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="download_num", property="downloadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="view_num", property="viewNum", jdbcType=JdbcType.INTEGER),
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.VARCHAR)
    })
    List<TBootstrapRes> selectByExample(TBootstrapResExample example);

    @Select({
        "select",
        "tid, title, memo, code, face_url, view_url, dir_key, p_dir_key, dir_name, qq, ",
        "status, download_num, view_num, file_id",
        "from t_bootstrap_res",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="face_url", property="faceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="view_url", property="viewUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="dir_key", property="dirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_dir_key", property="pDirKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="dir_name", property="dirName", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="download_num", property="downloadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="view_num", property="viewNum", jdbcType=JdbcType.INTEGER),
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.VARCHAR)
    })
    TBootstrapRes selectByPrimaryKey(Integer tid);

    @UpdateProvider(type=TBootstrapResSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBootstrapRes record);

    @Update({
        "update t_bootstrap_res",
        "set title = #{title,jdbcType=VARCHAR},",
          "memo = #{memo,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "face_url = #{faceUrl,jdbcType=VARCHAR},",
          "view_url = #{viewUrl,jdbcType=VARCHAR},",
          "dir_key = #{dirKey,jdbcType=VARCHAR},",
          "p_dir_key = #{pDirKey,jdbcType=VARCHAR},",
          "dir_name = #{dirName,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "download_num = #{downloadNum,jdbcType=INTEGER},",
          "view_num = #{viewNum,jdbcType=INTEGER},",
          "file_id = #{fileId,jdbcType=VARCHAR}",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBootstrapRes record);
}