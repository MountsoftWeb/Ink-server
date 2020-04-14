package com.ink.server.dao.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface categoryMapper {
    // 返回所有标签 key value
    List<HashMap<Integer, String>> getCategoryies();
}