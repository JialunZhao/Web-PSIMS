package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesbackGoodsLog;
import com.ai.psims.web.model.SalesbackGoodsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesbackGoodsLogMapper {
    int countByExample(SalesbackGoodsLogExample example);

    int deleteByExample(SalesbackGoodsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(SalesbackGoodsLog record);

    int insertSelective(SalesbackGoodsLog record);

    List<SalesbackGoodsLog> selectByExample(SalesbackGoodsLogExample example);

    SalesbackGoodsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") SalesbackGoodsLog record, @Param("example") SalesbackGoodsLogExample example);

    int updateByExample(@Param("record") SalesbackGoodsLog record, @Param("example") SalesbackGoodsLogExample example);

    int updateByPrimaryKeySelective(SalesbackGoodsLog record);

    int updateByPrimaryKey(SalesbackGoodsLog record);
}