package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbGoods2customerLog;
import com.ai.psims.web.model.TbGoods2customerLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoods2customerLogMapper {
    int countByExample(TbGoods2customerLogExample example);

    int deleteByExample(TbGoods2customerLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbGoods2customerLog record);

    int insertSelective(TbGoods2customerLog record);

    List<TbGoods2customerLog> selectByExample(TbGoods2customerLogExample example);

    TbGoods2customerLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbGoods2customerLog record, @Param("example") TbGoods2customerLogExample example);

    int updateByExample(@Param("record") TbGoods2customerLog record, @Param("example") TbGoods2customerLogExample example);

    int updateByPrimaryKeySelective(TbGoods2customerLog record);

    int updateByPrimaryKey(TbGoods2customerLog record);
}