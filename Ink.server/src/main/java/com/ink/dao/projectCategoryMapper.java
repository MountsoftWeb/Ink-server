package com.ink.dao;

import com.ink.server.common.model.entity.project_category;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface projectCategoryMapper {
    project_category selectAll();
}