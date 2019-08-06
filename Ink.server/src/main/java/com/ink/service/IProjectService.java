package com.ink.service;

import com.ink.model.entity.Project;
import com.ink.model.entity.appreciate;
import com.ink.model.entity.pageBean;
import com.ink.model.response.projectDetailResponse;

import java.util.ArrayList;

public interface IProjectService {
    ArrayList<Project> getProjectByUsername(String phone);

    ArrayList<Project> getAllProject();

    ArrayList<Project> getProject(String category);

    boolean updateAppreciate(appreciate appreciate, String phone);

    boolean insertAppreciate(appreciate appreciate, String phone);

    projectDetailResponse getProjectDetail(Integer projectId, String phone);

    pageBean<Project> getPageNum(int pageNum, int pageSize);

    ArrayList getHotProject();

    boolean countAppreciates(String projectId);
}
