package com.ink.user;

import com.ink.model.entity.user_login;
import com.ink.model.entity.login.userEntity;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Created by carlos
 */

@RestController
public class loginController {
    @Autowired
    IUserService iUserService;

    private Logger log = LoggerFactory.getLogger(loginController.class);

    @PostMapping(value= "/login")
    public Result login(@RequestBody userEntity userEntity, HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        user_login user_login = new user_login();
        user_login.setLoginip(ip);
        
        // String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
//      user_login.setLogintime(String.valueOf(System.currentTimeMillis()));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String testDate = df.format(new Date());//格式化当前日期
        user_login.setLogintime(testDate);
        log.info("登录信息: ip " + ip );
        log.info(user_login.getLogintime());
        log.info("phone = " + userEntity.getPhone());
        log.info("password = " + userEntity.getPassword());
        log.info("user_login = " + userEntity.toString());

        // 登录判断
        Result result = iUserService.login(userEntity, ip);

        return result;
    }

   

     @PostMapping("/test/life")
     public String test(ServletRequest request){
         String id = (String) request.getAttribute("name");
         System.out.println(id);
        return "123";
     }

}
