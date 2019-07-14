package com.ink.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletRequest;

import com.ink.service.IUserService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ink.model.entity.*;

@RestController
public class avatorController {
    @Autowired
    IUserService iUserService;

    /**
     * 添加头像，服务器地址为 /home/carlos/images/user 
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/test/updatePicture")
    public Result addImage(@RequestParam(name = "image_data", required = false) MultipartFile file, ServletRequest request) {
        Result result = new Result();
        // 文件上传 本地文件目录
        String path = "/Users/carlos/Documents/images";
        // 服务器路径
        // String path = "/home/carlos/image";
        
        // 获取更新头像用户的用户名
        String username = (String) request.getAttribute("name");
        if (!file.isEmpty()) {
            try {
                // 图片命名
                String userNamePicture = username + ".png";
                String userPicturePath = path + "/" + userNamePicture;
                String mysqlPicture = "/hello/" + username + ".png";
                // 存储路径到数据库
                User user = new User(username, mysqlPicture);
                boolean bool = iUserService.updatePicture(user);

                File newFile = new File(userPicturePath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();

                result.setMessage("成功");
                result.setCode("25");   // 头像上传成功
                return result;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                result.setCode("23");

                return result;
            } catch (IOException e) {
                e.printStackTrace();
                result.setCode("24");

                return result;
            }
        }else{
            result.setCode("404");
            return result;
        }
        
    }

    @PostMapping(value = "/getImage")
     public byte[] getImage() throws IOException {

         File file = new File("/Users/carlos/Documents/images/newPIC.jpeg");
         System.out.println("++++++++++++++++++");

         FileInputStream inputStream = new FileInputStream(file);

         byte[] bytes = new byte[inputStream.available()];

         inputStream.read(bytes, 0, inputStream.available());

         return bytes;
     }

    @GetMapping("/test/getPicture")
    public Result getPicture(ServletRequest request){
        Result result = new Result();
        String username = (String) request.getAttribute("name");

        String path = iUserService.selectPicture(username);
        System.out.println(path);

        result.setCode("200");
        result.setMessage("/hello/123.png");
        return result;
    }

}