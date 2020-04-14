package com.ink.server.dao.mapper;


import com.ink.server.dao.entity.login.userEntity;
import com.ink.server.dao.entity.user_login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface user_loginMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(user_login record);

    int insertSelective(user_login record);


    user_login selectByPrimaryKey(Integer id);

    user_login login(@Param("userEntity") userEntity userEntity);   // 登录验证

    boolean update(@Param("user_login") user_login user_login);      // 更新是否成功


    int updateByPrimaryKeySelective(user_login record);

    int updateByPrimaryKey(user_login record);

    int registerUser(@Param("user_login") user_login user_login);     // 注册新用户，添加登录信息
}