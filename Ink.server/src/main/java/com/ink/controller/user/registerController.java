package com.ink.controller.user;

import com.ink.model.entity.login.userEntity;
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
    @PostMapping(value = "/register")
    public Result register(@RequestBody userEntity userEntity){
        Result result = new Result();
        boolean bool = iUserService.registerUser(userEntity);
        if (bool){
            result.setCode("200");
            return result;
        }else{
            result.setCode("400");
            result.setMessage("注册失败");
            return result;
        }
        
    }
    @GetMapping(value = "/checkUser")
    public Result checkUser(@RequestParam(value = "username")String username){
        boolean bool = iUserService.checkUser(username);
        Result result = new Result();
        return result;
    }
}