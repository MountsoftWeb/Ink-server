package com.ink.dao;

import com.ink.entity.User;
import com.ink.entity.User_login;
import com.ink.entity.login.UserEntity;
import com.ink.entity.user_loginExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface user_loginMapper {
    long countByExample(user_loginExample example);

    int deleteByExample(user_loginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User_login record);

    int insertSelective(User_login record);

    List<User_login> selectByExample(user_loginExample example);

    User_login selectByPrimaryKey(Integer id);

    User_login login(@Param("userEntity") UserEntity userEntity);   // 登录验证

    Boolean update(@Param("user_login")User_login user_login);

    int updateByExampleSelective(@Param("record") User_login record, @Param("example") user_loginExample example);

    int updateByExample(@Param("record") User_login record, @Param("example") user_loginExample example);

    int updateByPrimaryKeySelective(User_login record);

    int updateByPrimaryKey(User_login record);
}