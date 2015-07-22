package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbSalesGoods;
import com.ai.psims.web.model.TbSalesGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSalesGoodsMapper {
    int countByExample(TbSalesGoodsExample example);

    int deleteByExample(TbSalesGoodsExample example);

    int deleteByPrimaryKey(Integer salesGoodsId);

    int insert(TbSalesGoods record);

    int insertSelective(TbSalesGoods record);

    List<TbSalesGoods> selectByExample(TbSalesGoodsExample example);

    TbSalesGoods selectByPrimaryKey(Integer salesGoodsId);

    int updateByExampleSelective(@Param("record") TbSalesGoods record, @Param("example") TbSalesGoodsExample example);

    int updateByExample(@Param("record") TbSalesGoods record, @Param("example") TbSalesGoodsExample example);

    int updateByPrimaryKeySelective(TbSalesGoods record);

    int updateByPrimaryKey(TbSalesGoods record);
}