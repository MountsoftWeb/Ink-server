package com.ink.service.Impl;

import java.util.HashMap;
import java.util.List;

import com.ink.dao.categoryMapper;
import com.ink.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class categoryServiceImpl implements ICategoryService {
    @Autowired
    categoryMapper categoryMapper;
    @Override
    public List<HashMap<Integer, String>> getCategoryies() {
        return categoryMapper.getCategoryies();
    }

}