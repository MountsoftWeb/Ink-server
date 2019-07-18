package com.ink.controller;

import java.util.HashMap;
import java.util.List;

import com.ink.service.ICategoryService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class categoryController {
    @Autowired
    ICategoryService iCategoryService;
    
    @GetMapping("/category/getCategories")
    public Result getCategories(){
        Result result = new Result();

        List<HashMap<Integer, String>> list = iCategoryService.getCategoryies();
        System.out.println("x");
        result.setCode("200");
        result.setData(list);
        return result;
    }
}