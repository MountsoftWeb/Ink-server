package com.ink.server.dao.mapper;

import java.util.ArrayList;


import com.ink.server.dao.entity.follow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface followMapper {

    ArrayList getFollowByUserId(@Param("userId") Integer userId);

    ArrayList getFansByUserId(@Param("userId") Integer userId);

    Integer selectByUserIdStatus(@Param("userId") Integer userId, @Param("followId") Integer followId);

    Integer insertFollow(@Param("follow") follow follow);

    Integer updataFollow(@Param("follow") follow follow);

    ArrayList getFollows(@Param("myId") Integer myId);

    ArrayList getFans(@Param("myId") Integer myId);
}