package com.ink.dao;

import java.util.ArrayList;

import com.ink.server.common.model.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUserid();

    int selectByUsername(@Param("phone")String phone);    // 按照用户名找到用户对应主健

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    boolean updatePicture(@Param("user")User user);

    String selectPicture(@Param("phone")String phone);

    User getDetail(@Param("phone")String phone);

    int registerUser(@Param("user")User user);

    boolean checkUser(@Param("phone")String phone);

    boolean creatFile(@Param("phone")String phone);

    ArrayList getHotUser();

    boolean updateDeatil(@Param("user")User user);

}