package com.sobt.pro.dao.func;

import com.sobt.pro.dao.bean.TBootstrapTag;
import com.sobt.pro.dao.bean.TBootstrapTagExample;
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

public interface TBootstrapTagMapper {
    @Delete({
        "delete from t_bootstrap_tag",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tid);

    @Insert({
        "insert into t_bootstrap_tag (text, status, ",
        "p_tid, code)",
        "values (#{text,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{pTid,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insert(TBootstrapTag record);

    @InsertProvider(type=TBootstrapTagSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insertSelective(TBootstrapTag record);

    @SelectProvider(type=TBootstrapTagSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="p_tid", property="pTid", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR)
    })
    List<TBootstrapTag> selectByExample(TBootstrapTagExample example);

    @Select({
        "select",
        "tid, text, status, p_tid, code",
        "from t_bootstrap_tag",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="p_tid", property="pTid", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR)
    })
    TBootstrapTag selectByPrimaryKey(Integer tid);

    @UpdateProvider(type=TBootstrapTagSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBootstrapTag record);

    @Update({
        "update t_bootstrap_tag",
        "set text = #{text,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "p_tid = #{pTid,jdbcType=INTEGER},",
          "code = #{code,jdbcType=VARCHAR}",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBootstrapTag record);
}