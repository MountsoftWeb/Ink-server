package com.ink.server.web.user;

import com.ink.server.common.utils.Json.Result;
import com.ink.server.dao.entity.login.userEntity;
import com.ink.server.service.IUserService;

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
            iUserService.creatFile(userEntity.getPhone());
            result.setCode("200");
            return result;
        }else{
            result.setCode("400");
            result.setMessage("注册失败");
            return result;
        }
        
    }
    @PostMapping(value = "/checkUser")
    public Result checkUser(@RequestParam(value = "username")String username){
        boolean bool = iUserService.checkUser(username);
        Result result = new Result();
        if (bool){
            result.setCode("21");
        }else{
            result.setCode("200");
        }
        return result;
    }
}