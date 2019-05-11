package com.ink.dao;

import com.ink.entity.CommodityCategory;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface commodityCategoryMapper {
    CommodityCategory selectAll();
}