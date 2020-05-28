package com.ink.server.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Mapper
@Configuration
public interface TestMapper {
    HashMap test();
}
