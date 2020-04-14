package com.ink.server.service.Impl;

import com.ink.server.dao.entity.Project;
import com.ink.server.dao.entity.appreciate;
import com.ink.server.dao.entity.pageBean;
import com.ink.server.dao.mapper.followMapper;
import com.ink.server.dao.mapper.projectMapper;
import com.ink.server.dao.mapper.userMapper;
import com.ink.server.service.IProjectService;
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
    public ArrayList<Project> getProjectByUsername(String phone) {
        Integer id = userMapper.selectByUsername(phone);
        return projectMapper.selectByUserId(id);
    }
    public ArrayList<Project> getAllProject() {
        return projectMapper.selectAllProject();
    }

    public ArrayList<Project> getProject(String category) {
        Integer categoryId = Integer.valueOf(category);
        ArrayList<Project> list = projectMapper.selectByCategory(categoryId);

        return list;
    }

    public boolean updateAppreciate(appreciate appreciate, String phone) {
        // Integer userId = userMapper.selectByUsername(username);

        // System.out.println(testDate);
        // String current = df.format(System.currentTimeMillis());
        Integer userId = userMapper.selectByUsername(phone);
        appreciate.setUserId(userId);
        return projectMapper.updateAppreciate(appreciate);
    }
    public boolean insertAppreciate(appreciate appreciate, String phone) {

        // System.out.println(testDate);
        // String current = df.format(System.currentTimeMillis());
        // appreciate appreciate = new appreciate();
        // appreciate.setProjectId(projectId);
        // appreciate.setUserId(userId);
        // appreciate.setAppreciateTime(testDate);
        Integer userId = userMapper.selectByUsername(phone);
        appreciate.setUserId(userId);
        return projectMapper.insertAppreciate(appreciate);
    }

//    public projectDetailResponse getProjectDetail(Integer projectId, String phone) {
//        Integer myId = userMapper.selectByUsername(phone);
//        Integer projectUserId = projectMapper.selectUserIdByProjectId(projectId);
//
//        projectDetailResponse projectResponse = projectMapper.selectByProjectId(projectId, myId);
//        Integer followStatus = followMapper.selectByUserIdStatus(projectUserId, myId);
//        projectResponse.setUserFollowStatus(followStatus);
//        return projectResponse;
//    }

    public pageBean getPageNum(int pageNum, int pageSize) {

        ArrayList list = projectMapper.selectAllProject();
//        pageBean pageBean = new pageBean<>(pageNum, pageSize, list.size());
//        pageBean.setList(list);
        return null;
	}

    public ArrayList getHotProject() {

        return projectMapper.getHotProject();
    }

    public boolean countAppreciates(String projectId) {
        Integer id = Integer.valueOf(projectId);
        return projectMapper.countAppreciates(id);
    }
}
