package com.ink.service.Impl;

import com.ink.dao.projectMapper;
import com.ink.dao.userMapper;
import com.ink.model.entity.Project;
import com.ink.model.entity.appreciate;
import com.ink.model.entity.pageBean;
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
    public ArrayList<Project> getProjectByUsername(String userName) {
        Integer id = userMapper.selectByUsername(userName);
        return projectMapper.selectByUserId(id);
    }

    @Override
    public ArrayList<Project> getAllProject() {
        return projectMapper.selectAllProject();
    }

    @Override
    public ArrayList<Project> getProject(String id) {
        Integer label = Integer.valueOf(id);
        ArrayList<Project> list = projectMapper.selectByLabel(label);
        
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

    @Override
    public pageBean getPageNum(int pageNum, int pageSize) {

        ArrayList list = projectMapper.selectAllProject();
        pageBean pageBean = new pageBean<>(pageNum, pageSize, list.size());
        
        pageBean.setList(list);
        return pageBean;
	}
}
