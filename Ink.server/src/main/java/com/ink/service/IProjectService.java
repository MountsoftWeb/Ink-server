package com.ink.service;

import com.ink.model.entity.Project;
import com.ink.model.entity.appreciate;
import com.ink.model.entity.pageBean;
import com.ink.model.response.projectDetailResponse;

import java.util.ArrayList;

public interface IProjectService {
    ArrayList<Project> getProjectByUsername(String userName);

    ArrayList<Project> getAllProject();

    ArrayList<Project> getProject(String id);

    void updataAppreciate(appreciate appreciate);

    void insertAppreciate(appreciate appreciate);

    projectDetailResponse getProjectDetail(Integer projectId);

    pageBean<Project> getPageNum(int pageNum, int pageSize);
}
