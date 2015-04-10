package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesGoodsLog;
import com.ai.psims.web.model.SalesGoodsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesGoodsLogMapper {
    int countByExample(SalesGoodsLogExample example);

    int deleteByExample(SalesGoodsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(SalesGoodsLog record);

    int insertSelective(SalesGoodsLog record);

    List<SalesGoodsLog> selectByExample(SalesGoodsLogExample example);

    SalesGoodsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") SalesGoodsLog record, @Param("example") SalesGoodsLogExample example);

    int updateByExample(@Param("record") SalesGoodsLog record, @Param("example") SalesGoodsLogExample example);

    int updateByPrimaryKeySelective(SalesGoodsLog record);

    int updateByPrimaryKey(SalesGoodsLog record);
}