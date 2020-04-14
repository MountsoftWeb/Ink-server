package com.ink.server.dao.mapper;

import java.util.HashMap;

import java.util.List;


import com.ink.server.dao.entity.label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface labelMapper {
    // 返回所有标签 key value
    List<HashMap<Integer, String>> getLabel();
    // 插入新标签
    Integer insertLabel(@Param("label") label label);
}