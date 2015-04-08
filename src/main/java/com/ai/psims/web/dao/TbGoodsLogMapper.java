package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbGoodsLog;
import com.ai.psims.web.model.TbGoodsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsLogMapper {
    int countByExample(TbGoodsLogExample example);

    int deleteByExample(TbGoodsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbGoodsLog record);

    int insertSelective(TbGoodsLog record);

    List<TbGoodsLog> selectByExample(TbGoodsLogExample example);

    TbGoodsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbGoodsLog record, @Param("example") TbGoodsLogExample example);

    int updateByExample(@Param("record") TbGoodsLog record, @Param("example") TbGoodsLogExample example);

    int updateByPrimaryKeySelective(TbGoodsLog record);

    int updateByPrimaryKey(TbGoodsLog record);
}