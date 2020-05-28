package com.ink.server.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
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
    public JSONObject test() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "carlos");
        ArrayList<String> list = new ArrayList<>();
        list.add("dasf");
        list.add("dasfas");
        list.add("dfsafdasdf");
        jsonObject.put("demose", list);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("dsfsdf", 1);
        map.put("dfafdsf", 2);
        map.put("cvvxcv", 3);
        jsonObject.put("hashmap", map);
        logger.info(testMapper.test().toString());
        return jsonObject;
    }
}
