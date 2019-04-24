package com.ink.controller.user;

import com.ink.entity.login.userEntity;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerController{
    @Autowired
    IUserService iUserService;
    @Autowired
    Result result;
    @PostMapping(value = "/register")
    public Result register(@RequestBody userEntity userEntity){
        boolean bool = iUserService.registerUser(userEntity);

        return null;
    }
    @GetMapping(value = "checkUser")
    public Result checkUser(@RequestParam(value = "username")String username){
        boolean bool = iUserService.checkUser(username);

        return result;
    }
}