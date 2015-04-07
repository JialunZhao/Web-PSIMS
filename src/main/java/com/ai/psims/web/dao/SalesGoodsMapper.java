package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesGoodsMapper {
    int countByExample(SalesGoodsExample example);

    int deleteByExample(SalesGoodsExample example);

    int deleteByPrimaryKey(Integer salesGoodsId);

    int insert(SalesGoods record);

    int insertSelective(SalesGoods record);

    List<SalesGoods> selectByExample(SalesGoodsExample example);

    SalesGoods selectByPrimaryKey(Integer salesGoodsId);

    int updateByExampleSelective(@Param("record") SalesGoods record, @Param("example") SalesGoodsExample example);

    int updateByExample(@Param("record") SalesGoods record, @Param("example") SalesGoodsExample example);

    int updateByPrimaryKeySelective(SalesGoods record);

    int updateByPrimaryKey(SalesGoods record);
}