package com.ink.server.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.ink.server.common.utils.Json.Result;
import com.ink.server.common.utils.response.ApiResponse;
import com.ink.server.common.utils.response.RetResponse;
import com.ink.server.service.DemoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class DemoController {
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);


    @Autowired
    DemoService demoService;
    @GetMapping("test")
    @ResponseBody
    public ApiResponse test(@RequestParam(value = "demo",required = true) String demo) {
        logger.info(String.valueOf(demoService.test()));
        ArrayList arrayList = new ArrayList();
//        arrayList.get(12);
//        logger.info(String.valueOf(ApiResponse.success()));
        Result result = new Result();
//        return result.setData(demoService.test());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dsd", "ds");
        return RetResponse.ofData(demoService.test());
    }
}
