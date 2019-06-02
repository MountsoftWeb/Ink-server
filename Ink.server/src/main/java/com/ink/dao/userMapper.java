package com.ink.dao;

import java.util.List;

import com.ink.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List selectByUserid();

    int selectByUsername(@Param("userName")String userName);    // 按照用户名找到用户对应主健

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    boolean updatePicture(@Param("user")User user);

    String selectPicture(@Param("userName")String userName);

    User getDetail(@Param("userName")String userName);

    int registerUser(@Param("user")User user);

    boolean checkUser(@Param("userName")String userName);
}