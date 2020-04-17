package com.ink.server.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface TestMapper {
    HashMap test();
}
