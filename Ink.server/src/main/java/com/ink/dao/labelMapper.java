package com.ink.dao;

import java.util.HashMap;

import java.util.List;

import com.ink.server.common.model.entity.label;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface labelMapper {
    // 返回所有标签 key value
    List<HashMap<Integer, String>> getLabel();
    // 插入新标签
    Integer insertLabel(@Param("label") label label);
}