package com.ink.dao;

import com.ink.model.entity.Project;
import com.ink.model.entity.appreciate;
import com.ink.model.entity.label;
import com.ink.model.response.projectDetailResponse;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface projectMapper {
    Project selectByUser(Integer id);

    ArrayList<Project> selectByUserId(@Param("id") Integer id);

    ArrayList<Project> selectAllProject();

    projectDetailResponse selectByProjectId(@Param("projectId") Integer projectId);

    ArrayList<Project> selectByLabel(@Param("label") Integer label);

    boolean uploadFile(@Param("project") Project project);

    boolean updataAppreciate(@Param("appreciate")appreciate appreciate);

    boolean insertAppreciate(@Param("appreciate")appreciate appreciate);
}