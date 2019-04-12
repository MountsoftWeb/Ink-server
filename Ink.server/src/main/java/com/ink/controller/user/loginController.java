package com.ink.controller.user;

import com.ink.entity.User_login;
import com.ink.entity.login.userEntity;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by carlos
 */

@RestController
public class loginController {
    @Autowired
    IUserService iUserService;


//    @PostMapping("/test1")
//    public String test(){
//
////        User s = iUserService.longin("123","123");
////        System.out.println("============" + s.toString());
//        return "d";
//    }
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
        User_login user_login = new User_login();
        System.out.println(ip);
        user_login.setLoginip(ip);

        Date data = new Date();

//        user_login.setLogintime(String.valueOf(System.currentTimeMillis()));
        user_login.setLogintime(data.toString());
        System.out.println(user_login.getLogintime());

        System.out.println("username = " + userEntity.getUsername());
        System.out.println("password = " + userEntity.getPassword());
        System.out.println("user_login = " + userEntity.toString());

        String jwtToken = Jwts.builder().setSubject("123").claim("roles", "member").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        // 登录判断
        Result result = iUserService.longin(userEntity, ip);
        // 将 token 传入 result
        result.setToken(jwtToken);
        return result;
    }


    @PostMapping("/addImage")
    public Result addImage(@RequestParam(name = "image_data", required = false) MultipartFile file) {
        Result result = new Result();
        //文件上传
        System.out.println("====================");
        if (!file.isEmpty()) {
            try {
                //图片命名
                String newCompanyImageName = "newPIC.png";
                String newCompanyImagepath = "/Users/carlos/Documents/images/" + newCompanyImageName;
                File newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                result.setCode("23");

                return result;
            } catch (IOException e) {
                e.printStackTrace();
                result.setCode("24");

                return result;
            }
        }
        result.setCode("25");

        return result;
    }

    @PostMapping(value = "/getImage",produces = MediaType.IMAGE_JPEG_VALUE)
     public byte[] getImage() throws IOException {

         File file = new File("/Users/carlos/Documents/images/newPIC.jpeg");
         System.out.println("++++++++++++++++++");

         FileInputStream inputStream = new FileInputStream(file);

         byte[] bytes = new byte[inputStream.available()];

         inputStream.read(bytes, 0, inputStream.available());

         return bytes;
     }

     @PostMapping("/test/life")
     public String test(){
        return "123";
     }

}
