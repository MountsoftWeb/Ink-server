package com.ink.server.service.Impl;

import com.ink.server.common.utils.Json.Result;
import com.ink.server.dao.entity.*;
import com.ink.server.dao.entity.login.userEntity;
import com.ink.server.dao.mapper.followMapper;
import com.ink.server.dao.mapper.projectCategoryMapper;
import com.ink.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Created by carlos
 */
@Service
public class userServiceImpl implements IUserService {
    @Autowired
    com.ink.server.dao.mapper.userMapper userMapper;
    @Autowired
    com.ink.server.dao.mapper.user_loginMapper user_loginMapper;
    @Autowired
    projectCategoryMapper commodityCategoryMapper;
    @Autowired
    com.ink.server.dao.mapper.projectMapper projectMapper;
    @Autowired
    com.ink.server.dao.mapper.labelMapper labelMapper;
    @Autowired
    followMapper followMapper;

    public boolean update(user_login user_login) {
        return user_loginMapper.update(user_login);
    }

    /**
     * 更新头像地址
     */

    public boolean updatePicture(User user) {
        return userMapper.updatePicture(user);
    }

    public Result login(userEntity userEntity, String ip) {
        return null;
    }


    public String selectPicture(String phone) {
        return userMapper.selectPicture(phone);
    }


    public User getDetail(String phone) {
        return userMapper.getDetail(phone);
    }

    /**
     * 注册用户
     */

    public boolean registerUser(userEntity userEntity) {
        User user = new User();
        // System.out.println(userEntity.getUsername());
        String phone = userEntity.getPhone();
        user.setUsername(phone);
        user.setRegisttime(new Date().toString());

        int register = userMapper.registerUser(user);
        if (register != 1) {
            return false;
        }
        Integer id = userMapper.selectByUsername(phone);
        if (id == null) {
            return false;
        }

        boolean creatFile = creatFile(phone); // 为用户创建所属文件夹
        user_login user_login = new user_login();
        user_login.setUserid(String.valueOf(id)); // 按照用户名找到主健
        user_login.setPassword(userEntity.getPassword());
        int register_user = user_loginMapper.registerUser(user_login); // 注册新用户，添加用户登录信息
        if (register_user == 1) {
            return true;
        } else {
            return false;
        }

        // System.out.println("register = " + register);
        // System.out.println("register_user = " + register_user);

    }

    /**
     * 检查用户是否重复
     */

    public boolean checkUser(String phone) {

        return userMapper.checkUser(phone);
    }


    public User test() {
        return userMapper.selectByUserid();
    }

    /**
     * 服务器需改变路径
     */

    public boolean creatFile(String phone) {
        // 文件上传 本地文件目录
        //    String path = "/Users/carlos/Documents/images/";
        // 服务器路径
        String path = "/home/carlos/image/";
        File newFile = new File(path + phone);
        boolean bool = newFile.mkdir();
        if (bool) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 文件上传，创建所需文件夹
     * 服务器上传需改变路径
     */

    public String creatProjectFile(String phone, StringBuffer time) {
        // 文件上传 本地文件目录
        StringBuilder path = new StringBuilder();
        // 长度 /Users/carlos/Documents/images/   31
        // /home/carlos/image/  19
        path.append("/Users/carlos/Documents/images/")
                .append(phone)
                .append("/")
                .append(time)
                .append("/")
                .append(String.valueOf(System.currentTimeMillis()));
        // 服务器路径
        // String path = "/home/carlos/image/";  19
        File newFile = new File(String.valueOf(path));
        boolean bool = newFile.mkdirs();
        if (bool) {
            return String.valueOf(path);
        } else {
            return "no";
        }
    }



    public boolean uploadFile(MultipartFile file, String phone, Project project, String path, String time) {
        if (!file.isEmpty()) {
            try {
                // 图片命名
                StringBuffer fileName = new StringBuffer();
                fileName.append(System.currentTimeMillis()).append(".png");
                StringBuffer userPicturePath = new StringBuffer();
                userPicturePath.append(path).append("/").append(fileName);
                StringBuffer mysqlPicture = new StringBuffer();

                // String url = path.substring(31);
                // 服务器 19
                // String url = path.substring(19);
                String url = path.substring(31);

                mysqlPicture.append("/hello/").append(url).append("/").append(fileName);
                // 存储路径到数据库
                project.setPicture(String.valueOf(mysqlPicture));
                projectMapper.uploadFile(project);
                File newFile = new File(String.valueOf(userPicturePath));
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
    }


    public Integer selectByUsername(String phone) {
        return userMapper.selectByUsername(phone);
    }


    public Integer insertLabel(String labelName) {

        label l = new label();
        // l.setId(null);
        l.setLabelName(labelName);

        labelMapper.insertLabel(l);
        return l.getId();
        // return l.getId();
    }


    public Integer deleteProjectId(Integer id) {
        return projectMapper.deleteProjectId(id);
    }


    public boolean deleteFileByProjectId(Integer id) {
        // String filename = projectMapper.deleteFileByProjectId(id);
        // 文件上传 本地文件目录
        // String path = "/Users/carlos/Documents/images/";
        // 服务器路径
//         String path = "/home/carlos/image/";
        // String filePath = path + filename.substring(7, filename.length());
        // System.out.println(filePath);

        // fileName.append(path).append(filePath);

        // File file = new File(filePath);
        // return deleteFile(file);
        Integer ds = projectMapper.deleteFileByProjectId(id);
        return true;

    }

    private boolean deleteFile(File file) {
        if (!file.exists()) {
            return false;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteFile(f);
            }
        }
        return file.delete();
    }


    public ArrayList getHotUser() {
        return userMapper.getHotUser();
    }


    public boolean updataFollow(follow follow) {

        int bool = followMapper.updataFollow(follow);
        return bool == 1 ? true : false;
    }


    public boolean insertFollow(follow follow) {

        int bool = followMapper.insertFollow(follow);
        return bool == 1 ? true : false;
    }


    public ArrayList getUserDeatilByUserId(Integer id) {
        return projectMapper.getUserDeatilByUserId(id);
    }


    public pageBean getPageNum(Integer id, Integer pageNum, Integer pageSize) {
        ArrayList list = projectMapper.getUserDeatilByUserId(id);
//        pageBean pageBean = new pageBean<>(pageNum, pageSize, list.size());
//        pageBean.setList(list);
        return null;
    }


    public ArrayList getFollowsFans(String id, String type) {
        Integer myId = userMapper.selectByUsername(id);
        if (type.equals("2")){
            ArrayList list = followMapper.getFollows(myId);
            return  list;
        }else if (type.equals("3")){
            ArrayList list = followMapper.getFans(myId);
            return  list;
        }else {
            return null;
        }
    }


    public boolean updateDeatil(User user) {
        return userMapper.updateDeatil(user);
    }
}
