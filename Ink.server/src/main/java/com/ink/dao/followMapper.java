package com.ink.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface followMapper {

    ArrayList getFollowByUserId(@Param("userId") Integer userId);

    ArrayList getFansByUserId(@Param("userId") Integer userId);

    Integer selectByUserIdStatus(@Param("userId") Integer userId, @Param("followId") Integer followId);
}