package com.ink.server.dao.mapper;


import com.ink.server.dao.entity.project_category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface projectCategoryMapper {
    project_category selectAll();
}