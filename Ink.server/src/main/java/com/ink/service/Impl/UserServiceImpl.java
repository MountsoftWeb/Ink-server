package com.ink.service.Impl;


import com.ink.dao.user_loginMapper;
import com.ink.entity.User;
import com.ink.entity.User_login;
import com.ink.entity.login.UserEntity;
import com.ink.entity.userMapper;
import com.ink.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by carlos
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    userMapper userMapper;
    @Autowired
    user_loginMapper user_loginMapper;

    @Override
    public User_login longin(UserEntity userEntity) {


        return user_loginMapper.login(userEntity);
    }

    @Override
    public Boolean update(User_login user_login) {
        return user_loginMapper.update(user_login);
    }
}
