package com.ink.dao;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface labelMapper {
    // 返回所有标签 key value
    List<HashMap<Integer, String>> getLabel();
}