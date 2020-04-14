package com.ink.server.service.Impl;

import java.util.HashMap;
import java.util.List;

import com.ink.server.service.ILabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class labelServiceImpl implements ILabelService {
    @Autowired
    com.ink.server.dao.mapper.labelMapper labelMapper;


    public List<HashMap<Integer, String>> getLabel() {
        return labelMapper.getLabel();
    }

}