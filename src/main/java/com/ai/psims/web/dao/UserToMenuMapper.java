package com.ai.psims.web.dao;

import com.ai.psims.web.model.UserToMenu;

public interface UserToMenuMapper {
    int deleteByPrimaryKey(Integer user2menuId);

    int insert(UserToMenu record);

    int insertSelective(UserToMenu record);

    UserToMenu selectByPrimaryKey(Integer user2menuId);

    int updateByPrimaryKeySelective(UserToMenu record);

    int updateByPrimaryKey(UserToMenu record);
}