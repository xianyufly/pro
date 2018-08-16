package com.sobt.pro.dao.func;

import com.sobt.pro.dao.bean.TBootResTag;
import com.sobt.pro.dao.bean.TBootResTagExample;
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

public interface TBootResTagMapper {
    @Delete({
        "delete from t_boot_res_tag",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tid);

    @Insert({
        "insert into t_boot_res_tag (tag_id, res_id)",
        "values (#{tagId,jdbcType=INTEGER}, #{resId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insert(TBootResTag record);

    @InsertProvider(type=TBootResTagSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tid", before=false, resultType=Integer.class)
    int insertSelective(TBootResTag record);

    @SelectProvider(type=TBootResTagSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.INTEGER),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.INTEGER)
    })
    List<TBootResTag> selectByExample(TBootResTagExample example);

    @Select({
        "select",
        "tid, tag_id, res_id",
        "from t_boot_res_tag",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.INTEGER),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.INTEGER)
    })
    TBootResTag selectByPrimaryKey(Integer tid);

    @UpdateProvider(type=TBootResTagSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBootResTag record);

    @Update({
        "update t_boot_res_tag",
        "set tag_id = #{tagId,jdbcType=INTEGER},",
          "res_id = #{resId,jdbcType=INTEGER}",
        "where tid = #{tid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBootResTag record);
}