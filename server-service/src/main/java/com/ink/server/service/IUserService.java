package com.ink.server.service;



import com.ink.server.common.Json.Result;
import com.ink.server.common.model.entity.*;
import com.ink.server.common.model.entity.login.userEntity;

import java.util.ArrayList;

public interface IUserService {
    Result login(userEntity userEntity, String ip);

    boolean update(user_login user_login);

    boolean updatePicture(User user);

    String selectPicture(String phone);

    User getDetail(String phone);
    // 检查用户名是否重复
    boolean checkUser(String phone);
    // 注册用户
    boolean registerUser(userEntity userEntity);
    // 查找用户 id
    Integer selectByUsername(String phone);

    User test();
    // 创建用户所属文件
    boolean creatFile(String phone);
    // 创建用户上传的文件夹
    String creatProjectFile(String phone, StringBuffer time);
    // uploadFile
//    boolean uploadFile(MultipartFile file, String phone, Project project, String path, String time);
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
    // 信息修改
    boolean updateDeatil(User user);
}
