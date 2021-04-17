package com.lrm.dao;

import com.lrm.po.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonMapper {
    //普通SQL

    @Select("select * from t_user where id=#{id}")
    List<User> getAllUsers(@Param("id")Long id);

    @Select("select * from t_user where username like '%${name}%'")
    List<User> getAllUsers1(@Param("name")String  name);

    @Select("select * from t_user where username like concat('%',#{name},'%')")
    List<User> getAllUsers12(@Param("name")String  name);

    @Insert("insert into t_user(phone) values(#{phone})")
    void insertUser(@Param("phone")String  phone);

    //
    //动态SQL  根据业务需求，用户的选项有可能为空，使用if和 when等一些标签进行判断后才拼接and 条件语句

    //Spring MVC
    // 支持Json格式传参 ["name":"宝宝","age":2,:,:]
    // 支持RESTful风格URL   http://localhost:8080/blog/68     /68 原来是/#id=68


}
