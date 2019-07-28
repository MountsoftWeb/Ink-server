package com.ink.dao;

import java.util.ArrayList;

import com.ink.model.entity.comment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface commentMapper {
    Integer insertComment(@Param("comment") comment comment);
    
    ArrayList getCommentList(@Param("projectId") Integer projectId);
}