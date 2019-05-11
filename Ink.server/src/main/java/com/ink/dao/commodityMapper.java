package com.ink.dao;

import com.ink.entity.Commodity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface commodityMapper {
    Commodity selectByUserid(Integer id);
}