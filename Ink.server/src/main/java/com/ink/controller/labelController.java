package com.ink.controller;

import java.util.ArrayList;

import com.ink.service.ILabelService;
import com.ink.utils.Json.Result;

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

        ArrayList list = iLabelService.getLabel();

        result.setCode("200");
        result.setData(list);
        return result;
    }
}