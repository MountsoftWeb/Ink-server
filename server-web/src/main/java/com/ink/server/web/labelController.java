package com.ink.server.web;

import java.util.HashMap;
import java.util.List;

import com.ink.server.common.utils.Json.Result;
import com.ink.server.service.ILabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class labelController {
    @Autowired
    ILabelService iLabelService;

    @GetMapping("/label/getLabel")
    public Result getLabel(){
        Result result = new Result();

        List<HashMap<Integer, String>> list = iLabelService.getLabel();
        // System.out.println("x");
        result.setCode("200");
        result.setData(list);
        return result;
    }


}