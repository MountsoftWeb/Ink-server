package com.ink.server.service;

import java.util.ArrayList;

public interface ICommentService {
    boolean insertComment(String projectId, String phone, String content);

    ArrayList getCommentList(String projectId);
}