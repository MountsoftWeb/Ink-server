package com.ink.service.Impl;

import com.ink.dao.projectCategoryMapper;
import com.ink.dao.projectMapper;
import com.ink.dao.user_loginMapper;
import com.ink.model.entity.User;
import com.ink.model.entity.user_login;
import com.ink.model.entity.login.userEntity;
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
    @Autowired
    projectCategoryMapper commodityCategoryMapper;
    @Autowired
    projectMapper commodityMapper;
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
        user_login user_login = user_loginMapper.login(userEntity);
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
    public boolean update(user_login user_login) {
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
        User user = new User();
        // System.out.println(userEntity.getUsername());
        String username = userEntity.getUsername();
        user.setUsername(username);
        user.setRegisttime(new Date().toString());
        
        int register = userMapper.registerUser(user);
        if (register != 1){
            return false;
        }
        Integer id = userMapper.selectByUsername(username);
        if (id == null){
            return false;
        }
        user_login user_login = new user_login();
        user_login.setUserid(String.valueOf(id));    // 按照用户名找到主健
        user_login.setPassword(userEntity.getPassword());
        int register_user = user_loginMapper.registerUser(user_login);  // 注册新用户，添加用户登录信息
        if (register_user == 1){
            return true;
        }else{
            return false;
        }

            // System.out.println("register = " + register);
            // System.out.println("register_user = " + register_user);
        
    }
    /**
     * 检查用户是否重复
     */
    @Override
    public boolean checkUser(String username) {
        
        return false;
    }

    @Override
    public User test() {
        return userMapper.selectByUserid();
    }

    
}
