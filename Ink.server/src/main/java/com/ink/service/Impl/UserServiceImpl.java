package com.ink.service.Impl;

import com.ink.dao.user_loginMapper;
import com.ink.entity.User;
import com.ink.entity.User_login;
import com.ink.entity.login.userEntity;
import com.ink.dao.userMapper;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Created by carlos
 */
@Service
public class userServiceImpl implements IUserService {
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


            String jwtToken = Jwts.builder()
                    .setSubject(userEntity.getUsername())
                    .claim("roles", "member")
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey")
                    .compact();

            /*
            Jwts.builder()
          .setId(UUID.randomUUID().toString())
          .setIssuedAt(new Date(currentTime))  //签发时间
          .setSubject("system")  //说明
          .setIssuer("shenniu003") //签发者信息
          .setAudience("custom")  //接收用户
          .compressWith(CompressionCodecs.GZIP)  //数据压缩方式

         .signWith(SignatureAlgorithm.HS256, encryKey) //加密方式
         .setExpiration(new Date(currentTime + secondTimeOut * 1000))  //过期时间戳
         .addClaims(claimMaps) //cla信息
         .compact();

         Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject().equals("Joe");

             */

            user_loginMapper.update(user_login);

            result.setMessage("登录成功");
            result.setCode("200");
            result.setSuccess(true);
            result.setToken(jwtToken);
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

    /**
     * 更新头像地址
     */
    @Override
    public boolean updatePicture(User user) {
        return userMapper.updatePicture(user);
    }

    @Override
    public String selectPicture(String username) {
        return userMapper.selectPicture(username);
    }

    @Override
    public User getDetail(String username) {
        return userMapper.getDetail(username);
    }

    /**
     * 注册用户
     */
    @Override
    public boolean registerUser(userEntity userEntity) {
        return false;
    }
    /**
     * 检查用户是否重复
     */
    @Override
    public boolean checkUser(String username) {
        
        return false;
    }

    
}
