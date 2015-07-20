package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbSalesGoodsLog;
import com.ai.psims.web.model.TbSalesGoodsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSalesGoodsLogMapper {
    int countByExample(TbSalesGoodsLogExample example);

    int deleteByExample(TbSalesGoodsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbSalesGoodsLog record);

    int insertSelective(TbSalesGoodsLog record);

    List<TbSalesGoodsLog> selectByExample(TbSalesGoodsLogExample example);

    TbSalesGoodsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbSalesGoodsLog record, @Param("example") TbSalesGoodsLogExample example);

    int updateByExample(@Param("record") TbSalesGoodsLog record, @Param("example") TbSalesGoodsLogExample example);

    int updateByPrimaryKeySelective(TbSalesGoodsLog record);

    int updateByPrimaryKey(TbSalesGoodsLog record);
}