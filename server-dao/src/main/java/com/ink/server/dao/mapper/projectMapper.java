package com.ink.server.dao.mapper;


import com.ink.server.dao.entity.Project;
import com.ink.server.dao.entity.appreciate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface projectMapper {
    Project selectByUser(Integer id);

    ArrayList<Project> selectByUserId(@Param("id") Integer id);

    ArrayList<Project> selectAllProject();


    ArrayList<Project> selectByCategory(@Param("categoryId") Integer categoryId);

    boolean uploadFile(@Param("project") Project project);

    boolean updateAppreciate(@Param("appreciate") appreciate appreciate);

    boolean insertAppreciate(@Param("appreciate") appreciate appreciate);

    Integer deleteFileByProjectId(@Param("id") Integer id);
    
    Integer deleteProjectId(@Param("id") Integer id);

    ArrayList getHotProject();

    Integer selectUserIdByProjectId(@Param("projectId") Integer projectId);

    ArrayList getUserDeatilByUserId(@Param("userId") Integer userId);

    boolean countAppreciates(@Param("id") Integer id);
   
}