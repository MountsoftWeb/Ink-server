package com.ink.server.service.Impl;

import com.ink.server.dao.mapper.TestMapper;
import com.ink.server.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "demoService")
public class DemoServiceImpl implements DemoService {
    private Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Autowired
    TestMapper testMapper;
    public String test() {
        logger.info(testMapper.test().toString());

        logger.info("==============================");
        return "hello world";
    }
}
