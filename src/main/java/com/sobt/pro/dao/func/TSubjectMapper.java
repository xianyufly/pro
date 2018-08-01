package com.sobt.pro.dao.func;

import com.sobt.pro.dao.bean.TSubject;
import com.sobt.pro.dao.bean.TSubjectExample;
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

public interface TSubjectMapper {
    @Delete({
        "delete from t_subject",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tid);

    @Insert({
        "insert into t_subject (sub_code, sub_name, ",
        "sub_status)",
        "values (#{subCode,jdbcType=VARCHAR}, #{subName,jdbcType=VARCHAR}, ",
        "#{subStatus,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insert(TSubject record);

    @InsertProvider(type=TSubjectSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insertSelective(TSubject record);

    @SelectProvider(type=TSubjectSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sub_code", property="subCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_name", property="subName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_status", property="subStatus", jdbcType=JdbcType.INTEGER)
    })
    List<TSubject> selectByExample(TSubjectExample example);

    @Select({
        "select",
        "tid, sub_code, sub_name, sub_status",
        "from t_subject",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sub_code", property="subCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_name", property="subName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_status", property="subStatus", jdbcType=JdbcType.INTEGER)
    })
    TSubject selectByPrimaryKey(Integer tid);

    @UpdateProvider(type=TSubjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSubject record);

    @Update({
        "update t_subject",
        "set sub_code = #{subCode,jdbcType=VARCHAR},",
          "sub_name = #{subName,jdbcType=VARCHAR},",
          "sub_status = #{subStatus,jdbcType=INTEGER}",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSubject record);
}