package com.ink.server.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ink.server.dao.entity.comment;
import com.ink.server.service.ICommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentServiceImpl implements ICommentService {
    @Autowired
    com.ink.server.dao.mapper.userMapper userMapper;
    @Autowired
    com.ink.server.dao.mapper.commentMapper commentMapper;
    public boolean insertComment(String projectId, String phone, String content) {
        comment comment = new comment();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String testDate = df.format(new Date());//格式化当前日期
        comment.setCommentTime(testDate);
        comment.setProjectId(Integer.valueOf(projectId));
        Integer userId = userMapper.selectByUsername(phone);
        comment.setUserId(userId);
        comment.setContent(content);
        Integer id = commentMapper.insertComment(comment);
        return id == 1 ? true : false;
    }

    public ArrayList getCommentList(String projectId) {
        return commentMapper.getCommentList(Integer.valueOf(projectId));
	}

}