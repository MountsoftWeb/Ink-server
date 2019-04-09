package com.ink.dao;

import com.ink.entity.User_login;
import com.ink.entity.login.userEntity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface user_loginMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(User_login record);

    int insertSelective(User_login record);


    User_login selectByPrimaryKey(Integer id);

    User_login login(@Param("userEntity") userEntity userEntity);   // 登录验证

    boolean update(@Param("user_login")User_login user_login);      // 更新是否成功


    int updateByPrimaryKeySelective(User_login record);

    int updateByPrimaryKey(User_login record);
}