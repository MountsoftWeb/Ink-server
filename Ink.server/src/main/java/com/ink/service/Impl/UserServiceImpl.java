package com.ink.service.Impl;


import com.ink.dao.user_loginMapper;
import com.ink.entity.User_login;
import com.ink.entity.login.userEntity;
import com.ink.dao.userMapper;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Created by carlos
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    userMapper userMapper;
    @Autowired
    user_loginMapper user_loginMapper;

    /**
     * 登录验证，信息验证无误，更新 user_login 的 ip 和 logintime
     * @param userEntity
     * @param ip
     * @return
     */
    @Override
    public Result longin(userEntity userEntity, String ip) {
        Result result = new Result();
        Date data = new Date();
        User_login user_login = user_loginMapper.login(userEntity);
        if (user_login != null){
            user_login.setLoginip(ip);
            user_login.setLogintime(data.toString());

            user_loginMapper.update(user_login);

            result.setMessage("登录成功");
            result.setCode("200");
            result.setSuccess(true);
            result.setData(data.toString());
            return result;
        }else {
            result.setCode("402");
            result.setMessage("登录失败，用户不存在");
            result.setSuccess(false);
            return result;
        }
    }

    @Override
    public boolean update(User_login user_login) {
        return user_loginMapper.update(user_login);
    }
}
