package com.ink.controller;

import com.ink.utils.Json.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class avatorController {


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
}