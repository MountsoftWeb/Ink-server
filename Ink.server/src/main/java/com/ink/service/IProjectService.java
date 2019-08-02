package com.ink.service;

import com.ink.model.entity.Project;
import com.ink.model.entity.appreciate;
import com.ink.model.entity.pageBean;
import com.ink.model.response.projectDetailResponse;

import java.util.ArrayList;

public interface IProjectService {
    ArrayList<Project> getProjectByUsername(String userName);

    ArrayList<Project> getAllProject();

    ArrayList<Project> getProject(String category, String label);

    boolean updataAppreciate(appreciate appreciate, String userName);

    boolean insertAppreciate(appreciate appreciate, String userName);

    projectDetailResponse getProjectDetail(Integer projectId, String userName);

    pageBean<Project> getPageNum(int pageNum, int pageSize);

    ArrayList getHotProject();

    boolean countAppreciates(String projectId);
}
