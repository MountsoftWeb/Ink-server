package com.ink.service;

import com.ink.model.entity.Project;

import java.util.ArrayList;

public interface IProjectService {
    ArrayList getProjectByUsername(String userName);

    ArrayList getAllProject();

    ArrayList getProject(String id);
}
