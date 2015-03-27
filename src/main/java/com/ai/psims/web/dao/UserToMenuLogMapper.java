package com.ai.psims.web.dao;

import com.ai.psims.web.model.UserToMenuLog;

public interface UserToMenuLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(UserToMenuLog record);

    int insertSelective(UserToMenuLog record);

    UserToMenuLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(UserToMenuLog record);

    int updateByPrimaryKey(UserToMenuLog record);
}