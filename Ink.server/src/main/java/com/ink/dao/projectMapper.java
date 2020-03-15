package com.ink.dao;

import com.ink.server.common.model.entity.Project;
import com.ink.server.common.model.entity.appreciate;
import com.ink.server.common.response.projectDetailResponse;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface projectMapper {
    Project selectByUser(Integer id);

    ArrayList<Project> selectByUserId(@Param("id") Integer id);

    ArrayList<Project> selectAllProject();

    projectDetailResponse selectByProjectId(@Param("projectId") Integer projectId, @Param("id") Integer id);

    ArrayList<Project> selectByCategory(@Param("categoryId") Integer categoryId);

    boolean uploadFile(@Param("project") Project project);

    boolean updateAppreciate(@Param("appreciate")appreciate appreciate);

    boolean insertAppreciate(@Param("appreciate")appreciate appreciate);

    Integer deleteFileByProjectId(@Param("id") Integer id);
    
    Integer deleteProjectId(@Param("id") Integer id);

    ArrayList getHotProject();

    Integer selectUserIdByProjectId(@Param("projectId") Integer projectId);

    ArrayList getUserDeatilByUserId(@Param("userId") Integer userId);

    boolean countAppreciates(@Param("id") Integer id);
   
}