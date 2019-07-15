package com.ink.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface labelMapper {

    ArrayList getLabel();
}