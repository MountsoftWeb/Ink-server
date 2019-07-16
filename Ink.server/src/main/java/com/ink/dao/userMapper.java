package com.ink.dao;

import com.ink.model.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUserid();

    int selectByUsername(@Param("userName")String userName);    // 按照用户名找到用户对应主健

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    boolean updatePicture(@Param("user")User user);

    String selectPicture(@Param("userName")String userName);

    User getDetail(@Param("userName")String userName);

    int registerUser(@Param("user")User user);

    boolean checkUser(@Param("username")String username);

    boolean creatFile(@Param("username")String username);
}