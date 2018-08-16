package com.sobt.pro.dao.func;

import com.sobt.pro.dao.bean.TUser;
import com.sobt.pro.dao.bean.TUserExample;
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

public interface TUserMapper {
    @Delete({
        "delete from t_user",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tid);

    @Insert({
        "insert into t_user (account, pwd, ",
        "nick_name)",
        "values (#{account,jdbcType=VARCHAR}, #{pwd,jdbcType=VARCHAR}, ",
        "#{nickName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insert(TUser record);

    @InsertProvider(type=TUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insertSelective(TUser record);

    @SelectProvider(type=TUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR)
    })
    List<TUser> selectByExample(TUserExample example);

    @Select({
        "select",
        "tid, account, pwd, nick_name",
        "from t_user",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR)
    })
    TUser selectByPrimaryKey(Integer tid);

    @UpdateProvider(type=TUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUser record);

    @Update({
        "update t_user",
        "set account = #{account,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR}",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TUser record);
}