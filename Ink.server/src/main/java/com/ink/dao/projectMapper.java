package com.ink.dao;

import com.ink.entity.Project;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface projectMapper {
    Project selectByUserid(Integer id);

    ArrayList selectByUsername(@Param("userName") String userName);
}