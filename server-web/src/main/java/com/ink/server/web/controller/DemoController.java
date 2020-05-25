package com.ink.server.web.controller;

import com.ink.server.common.utils.Json.Result;
import com.ink.server.service.DemoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);


    @Autowired
    DemoService demoService;
    @GetMapping("tttt")
    public Result test() {
        logger.info(demoService.test().toString());
        Result result = new Result();
        return result.setData(demoService.test());
    }
}
