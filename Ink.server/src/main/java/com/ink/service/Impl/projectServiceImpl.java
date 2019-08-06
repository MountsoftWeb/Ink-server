package com.ink.service.Impl;

import com.ink.dao.followMapper;
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
    @Autowired
    followMapper followMapper;
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
    public ArrayList<Project> getProject(String category) {
        Integer categoryId = Integer.valueOf(category);
        ArrayList<Project> list = projectMapper.selectByCategory(categoryId);
        
        return list;
    }

    @Override
    public boolean updateAppreciate(appreciate appreciate, String userName) {
        // Integer userId = userMapper.selectByUsername(username);
        
        // System.out.println(testDate);
        // String current = df.format(System.currentTimeMillis());  
        Integer userId = userMapper.selectByUsername(userName);
        appreciate.setUserId(userId);
        return projectMapper.updateAppreciate(appreciate);
    }

    @Override
    public boolean insertAppreciate(appreciate appreciate, String userName) {
        
        // System.out.println(testDate);
        // String current = df.format(System.currentTimeMillis());  
        // appreciate appreciate = new appreciate();
        // appreciate.setProjectId(projectId);
        // appreciate.setUserId(userId);
        // appreciate.setAppreciateTime(testDate);
        Integer userId = userMapper.selectByUsername(userName);
        appreciate.setUserId(userId);
        return projectMapper.insertAppreciate(appreciate);
    }

    @Override
    public projectDetailResponse getProjectDetail(Integer projectId, String userName) {
        Integer myId = userMapper.selectByUsername(userName);
        Integer projectUserId = projectMapper.selectUserIdByProjectId(projectId);

        projectDetailResponse projectResponse = projectMapper.selectByProjectId(projectId, myId);
        Integer followStatus = followMapper.selectByUserIdStatus(projectUserId, myId);
        projectResponse.setUserFollowStatus(followStatus);
        return projectResponse;
    }

    @Override
    public pageBean getPageNum(int pageNum, int pageSize) {

        ArrayList list = projectMapper.selectAllProject();
        pageBean pageBean = new pageBean<>(pageNum, pageSize, list.size());
        pageBean.setList(list);
        return pageBean;
	}

    @Override
    public ArrayList getHotProject() {
        
        return projectMapper.getHotProject();
    }

    @Override
    public boolean countAppreciates(String projectId) {
        Integer id = Integer.valueOf(projectId);
        return projectMapper.countAppreciates(id);
    }
}
