package com.ink.service.Impl;

import com.ink.dao.projectMapper;
import com.ink.dao.userMapper;
import com.ink.model.entity.appreciate;
import com.ink.model.response.projectDetailResponse;
import com.ink.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Created by carlos
 */
@Service
public class projectServiceImpl implements IProjectService {
    @Autowired
    projectMapper projectMapper;
    @Autowired
    userMapper userMapper;
    @Override
    public ArrayList getProjectByUsername(String userName) {
        Integer id = userMapper.selectByUsername(userName);
        return projectMapper.selectByUserId(id);
    }

    @Override
    public ArrayList getAllProject() {
        return projectMapper.selectAllProject();
    }

    @Override
    public ArrayList getProject(String id) {
        Integer label = Integer.valueOf(id);
        ArrayList list = projectMapper.selectByLabel(label);
        
        return list;
    }

    @Override
    public void updataAppreciate(appreciate appreciate) {
        // Integer userId = userMapper.selectByUsername(username);
        
        // System.out.println(testDate);
        // String current = df.format(System.currentTimeMillis());  
        
        projectMapper.updataAppreciate(appreciate);
    }

    @Override
    public void insertAppreciate(appreciate appreciate) {
        
        // System.out.println(testDate);
        // String current = df.format(System.currentTimeMillis());  
        // appreciate appreciate = new appreciate();
        // appreciate.setProjectId(projectId);
        // appreciate.setUserId(userId);
        // appreciate.setAppreciateTime(testDate);
        projectMapper.insertAppreciate(appreciate);
    }

    @Override
    public projectDetailResponse getProjectDetail(Integer projectId) {
        projectDetailResponse projectResponse = projectMapper.selectByProjectId(projectId);


        return projectResponse;
	}
}
