package com.ink.controller;

import javax.servlet.ServletRequest;

import com.ink.entity.User;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController{
    @Autowired
    IUserService iUserService;

    @PostMapping("/test/getDetail")
    public Result getDetail(ServletRequest request){
        Result result = new Result();

        String username = (String) request.getAttribute("name");
        User user = iUserService.getDetail(username);
        result.setCode("200");
        result.setData(user);
        System.err.println("getDetail");
        return result;
    }
}