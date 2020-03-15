package com.ink.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ink.dao.commentMapper;
import com.ink.dao.userMapper;
import com.ink.server.common.model.entity.comment;
import com.ink.service.ICommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentServiceImpl implements ICommentService {
    @Autowired
    userMapper userMapper;
    @Autowired
    commentMapper commentMapper;
    @Override
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

    @Override
    public ArrayList getCommentList(String projectId) {
        return commentMapper.getCommentList(Integer.valueOf(projectId));
	}

}