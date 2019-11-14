package com.ink.service.Impl;

import com.ink.dao.followMapper;
import com.ink.dao.labelMapper;
import com.ink.dao.projectCategoryMapper;
import com.ink.dao.projectMapper;
import com.ink.dao.user_loginMapper;
import com.ink.model.entity.Project;
import com.ink.model.entity.User;
import com.ink.model.entity.follow;
import com.ink.model.entity.label;
import com.ink.model.entity.pageBean;
import com.ink.model.entity.user_login;
import com.ink.model.entity.login.userEntity;
import com.ink.dao.userMapper;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    projectMapper projectMapper;
    @Autowired
    labelMapper labelMapper;
    @Autowired
    followMapper followMapper;
    /**
     * 登录验证，信息验证无误，更新 user_login 的 ip 和 logintime
     * 
     * @param userEntity
     * @param ip
     * @return
     */
    @Override
    public Result login(userEntity userEntity, String ip) {
        Result result = new Result();
        Date data = new Date();
        user_login user_login = user_loginMapper.login(userEntity);
        if (user_login != null) {
            user_login.setLoginip(ip);
            ;
            user_login.setLogintime(data.toString());

            String jwtToken = Jwts.builder().setSubject(userEntity.getPhone()).claim("roles", "member")
                    .setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            /*
             * Jwts.builder() .setId(UUID.randomUUID().toString()) .setIssuedAt(new
             * Date(currentTime)) //签发时间 .setSubject("system") //说明 .setIssuer("shenniu003")
             * //签发者信息 .setAudience("custom") //接收用户 .compressWith(CompressionCodecs.GZIP)
             * //数据压缩方式
             * 
             * .signWith(SignatureAlgorithm.HS256, encryKey) //加密方式 .setExpiration(new
             * Date(currentTime + secondTimeOut * 1000)) //过期时间戳 .addClaims(claimMaps)
             * //cla信息 .compact();
             * 
             * Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().
             * getSubject().equals("Joe");
             * 
             */
            boolean b = user_loginMapper.update(user_login);
            result.setMessage("登录成功");
            result.setCode("200");
            result.setSuccess(true);
            result.setToken(jwtToken);
            result.setData(data.toString());
            return result;
        } else {
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
    public String selectPicture(String phone) {
        return userMapper.selectPicture(phone);
    }

    @Override
    public User getDetail(String phone) {
        return userMapper.getDetail(phone);
    }

    /**
     * 注册用户
     */
    @Override
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
    @Override
    public boolean checkUser(String phone) {

        return userMapper.checkUser(phone);
    }

    @Override
    public User test() {
        return userMapper.selectByUserid();
    }

    /**
     * 服务器需改变路径
     */
    @Override
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
    @Override
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

    @Override
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

    @Override
    public Integer selectByUsername(String phone) {
        return userMapper.selectByUsername(phone);
    }

    @Override
    public Integer insertLabel(String labelName) {
        
        label l = new label();
        // l.setId(null);
        l.setLabelName(labelName);
        
        labelMapper.insertLabel(l);
        return l.getId();
        // return l.getId();
    }

    @Override
    public Integer deleteProjectId(Integer id) {
        return projectMapper.deleteProjectId(id);
    }

    @Override
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

    @Override
    public ArrayList getHotUser() {
        return userMapper.getHotUser();
	}

    @Override
    public boolean updataFollow(follow follow) {
        
        int bool = followMapper.updataFollow(follow);
        return bool == 1 ? true : false;
    }

    @Override
    public boolean insertFollow(follow follow) {
        
        int bool = followMapper.insertFollow(follow);
        return bool == 1 ? true : false;
    }

    @Override
    public ArrayList getUserDeatilByUserId(Integer id) {
        return projectMapper.getUserDeatilByUserId(id);
    }

    @Override
    public pageBean getPageNum(Integer id, Integer pageNum, Integer pageSize) {
        ArrayList list = projectMapper.getUserDeatilByUserId(id);
        pageBean pageBean = new pageBean<>(pageNum, pageSize, list.size());
        pageBean.setList(list);
        return pageBean;
	}

    @Override
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

    @Override
    public boolean updateDeatil(User user) {
        return userMapper.updateDeatil(user);
    }
}
