package com.ink.controller;

import java.awt.PageAttributes.MediaType;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ink.entity.*;

@RestController
public class avatorController {
    @Autowired
    IUserService iUserService;

    /**
     * 添加头像，服务器地址为 /home/carlos/images/user 
     * @param file
     * @return
     */
    @PostMapping("/addImage")
    public Result addImage(@RequestParam(name = "image_data", required = false) MultipartFile file, ServletRequest request) {
        Result result = new Result();
        //文件上传
        String path = "/Users/carlos/Documents/images";
        String username = (String) request.getAttribute("name");
        System.out.println("====================");
        if (!file.isEmpty()) {
            try {
                // 图片命名
                String newCompanyImageName = System.currentTimeMillis() + ".png";
                String newCompanyImagepath = path;
                // 存储路径到数据库
                User user = new User(username, path + username);
                boolean bool = iUserService.updateAvator(user);

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

    @PostMapping(value = "/getImage")
     public byte[] getImage() throws IOException {

         File file = new File("/Users/carlos/Documents/images/newPIC.jpeg");
         System.out.println("++++++++++++++++++");

         FileInputStream inputStream = new FileInputStream(file);

         byte[] bytes = new byte[inputStream.available()];

         inputStream.read(bytes, 0, inputStream.available());

         return bytes;
     }
}