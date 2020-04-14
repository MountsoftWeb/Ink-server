package com.ink.server.service.Impl;

import java.util.HashMap;
import java.util.List;


import com.ink.server.dao.mapper.categoryMapper;
import com.ink.server.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class categoryServiceImpl implements ICategoryService {
    @Autowired
    com.ink.server.dao.mapper.categoryMapper categoryMapper;
    public List<HashMap<Integer, String>> getCategoryies() {
        return categoryMapper.getCategoryies();
    }

}