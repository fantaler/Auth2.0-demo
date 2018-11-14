package com.qhy.dao;

import com.qhy.domain.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface UserMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    @Delete({
        "delete from user",
        "where `uid` = #{uid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer uid);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    @Insert({
        "insert into user (uname, upassword, ",
        "uemail)",
        "values (#{uname,jdbcType=VARCHAR}, #{upassword,jdbcType=VARCHAR}, ",
        "#{uemail,jdbcType=VARCHAR})"
    })
    int insert(User record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    int insertSelective(User record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    @Select({
        "select",
        "`uid`, uname, upassword, uemail",
        "from user",
        "where `uid` = #{uid,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(Integer uid);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    @Update({
        "update user",
        "set uname = #{uname,jdbcType=VARCHAR},",
          "upassword = #{upassword,jdbcType=VARCHAR},",
          "uemail = #{uemail,jdbcType=VARCHAR}",
        "where `uid` = #{uid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}