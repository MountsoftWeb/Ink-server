package com.ink.service;

import java.util.ArrayList;

import com.ink.model.entity.Project;
import com.ink.model.entity.User;
import com.ink.model.entity.follow;
import com.ink.model.entity.pageBean;
import com.ink.model.entity.user_login;
import com.ink.model.entity.login.userEntity;
import com.ink.utils.Json.Result;

import org.springframework.web.multipart.MultipartFile;

public interface IUserService {
    Result login(userEntity userEntity, String ip);

    boolean update(user_login user_login);

    boolean updatePicture(User user);

    String selectPicture(String username);

    User getDetail(String username);
    // 检查用户名是否重复
    boolean checkUser(String username);
    // 注册用户
    boolean registerUser(userEntity userEntity);
    // 查找用户 id
    Integer selectByUsername(String username);

    User test();
    // 创建用户所属文件
    boolean creatFile(String username);
    // 创建用户上传的文件夹
    String creatProjectFile(String username, StringBuffer time);
    // uploadFile
    boolean uploadFile(MultipartFile file, String username, Project project, String path, String time);
    // 插入新标签
    Integer insertLabel(String label);
    // 按照 project ID 返回文件路径，用于删除文件
    boolean deleteFileByProjectId(Integer id);

    Integer deleteProjectId(Integer id);
    // 获取热门用户
    ArrayList getHotUser();
    // 更新关注用户
    boolean updataFollow(follow follow);
    // 新增关注
    boolean insertFollow(follow follow);
    // 按照用户 ID 获取相关信息
    ArrayList getUserDeatilByUserId(Integer id);
    // 分页获取
    pageBean getPageNum(Integer id, Integer pageNum, Integer pageSize);

    // 获取用户相关关注 
    ArrayList getFollowsFans(String id, String type);
}
