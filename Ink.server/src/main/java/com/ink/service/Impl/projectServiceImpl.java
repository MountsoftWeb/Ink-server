package com.ink.service.Impl;

import com.ink.dao.projectMapper;
import com.ink.model.entity.Project;
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
    @Override
    public ArrayList getProjectByUsername(String userName) {
        return projectMapper.selectByUsername(userName);
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
}
