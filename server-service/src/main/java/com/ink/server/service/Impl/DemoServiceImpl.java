package com.ink.server.service.Impl;

import com.ink.server.dao.mapper.TestMapper;
import com.ink.server.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by carlos
 */
@Service(value = "demoService")
public class DemoServiceImpl implements DemoService {

    private static Logger logger = LoggerFactory.getLogger(DemoService.class);
    @Autowired
    TestMapper testMapper;
    public String test() {
        logger.info(testMapper.test().toString());
        return "hello world";
    }
}
