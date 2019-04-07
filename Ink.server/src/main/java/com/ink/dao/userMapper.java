package com.ink.entity;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userMapper {
    long countByExample(userExample example);

    int deleteByExample(userExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(userExample example);

    User selectByPrimaryKey(Integer id);

    List selectByUserid();

    int updateByExampleSelective(@Param("record") User record, @Param("example") userExample example);

    int updateByExample(@Param("record") User record, @Param("example") userExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}