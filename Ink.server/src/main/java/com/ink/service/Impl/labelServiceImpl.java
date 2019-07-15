package com.ink.service.Impl;

import java.util.ArrayList;

import com.ink.dao.labelMapper;
import com.ink.service.ILabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class labelServiceImpl implements ILabelService {
    @Autowired
    labelMapper labelMapper;


    @Override
    public ArrayList getLabel() {
        return labelMapper.getLabel();
    }

}