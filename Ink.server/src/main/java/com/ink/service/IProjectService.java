package com.ink.service;

import com.ink.model.entity.appreciate;
import com.ink.model.response.projectDetailResponse;

import java.util.ArrayList;

public interface IProjectService {
    ArrayList getProjectByUsername(String userName);

    ArrayList getAllProject();

    ArrayList getProject(String id);

    void updataAppreciate(appreciate appreciate);

    void insertAppreciate(appreciate appreciate);

    projectDetailResponse getProjectDetail(Integer projectId);
}
