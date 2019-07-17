package com.ink.dao;

import com.ink.model.entity.Project;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface projectMapper {
    Project selectByUser(Integer id);

    ArrayList selectByUserId(@Param("id") Integer id);

    ArrayList selectAllProject();

    ArrayList selectByLabel(@Param("label") Integer label);

    boolean uploadFile(@Param("project") Project project);
}