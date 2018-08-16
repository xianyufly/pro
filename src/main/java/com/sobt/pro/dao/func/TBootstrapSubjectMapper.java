package com.sobt.pro.dao.func;

import com.sobt.pro.dao.bean.TBootstrapSubject;
import com.sobt.pro.dao.bean.TBootstrapSubjectExample;
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

public interface TBootstrapSubjectMapper {
    @Delete({
        "delete from t_bootstrap_subject",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tid);

    @Insert({
        "insert into t_bootstrap_subject (text, code, ",
        "status, p_tid, href, ",
        "sub_type, sort, icon)",
        "values (#{text,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{pTid,jdbcType=INTEGER}, #{href,jdbcType=VARCHAR}, ",
        "#{subType,jdbcType=INTEGER}, #{sort,jdbcType=INTEGER}, #{icon,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insert(TBootstrapSubject record);

    @InsertProvider(type=TBootstrapSubjectSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insertSelective(TBootstrapSubject record);

    @SelectProvider(type=TBootstrapSubjectSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="p_tid", property="pTid", jdbcType=JdbcType.INTEGER),
        @Result(column="href", property="href", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_type", property="subType", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR)
    })
    List<TBootstrapSubject> selectByExample(TBootstrapSubjectExample example);

    @Select({
        "select",
        "tid, text, code, status, p_tid, href, sub_type, sort, icon",
        "from t_bootstrap_subject",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="p_tid", property="pTid", jdbcType=JdbcType.INTEGER),
        @Result(column="href", property="href", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_type", property="subType", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR)
    })
    TBootstrapSubject selectByPrimaryKey(Integer tid);

    @UpdateProvider(type=TBootstrapSubjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBootstrapSubject record);

    @Update({
        "update t_bootstrap_subject",
        "set text = #{text,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "p_tid = #{pTid,jdbcType=INTEGER},",
          "href = #{href,jdbcType=VARCHAR},",
          "sub_type = #{subType,jdbcType=INTEGER},",
          "sort = #{sort,jdbcType=INTEGER},",
          "icon = #{icon,jdbcType=VARCHAR}",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBootstrapSubject record);
}