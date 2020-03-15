package com.ink.service;

import com.ink.server.common.model.entity.Project;
import com.ink.server.common.model.entity.appreciate;
import com.ink.server.common.model.entity.pageBean;
import com.ink.server.common.response.projectDetailResponse;

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
