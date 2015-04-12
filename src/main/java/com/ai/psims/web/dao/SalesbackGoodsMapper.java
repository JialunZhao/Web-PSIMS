package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesbackGoods;
import com.ai.psims.web.model.SalesbackGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesbackGoodsMapper {
    int countByExample(SalesbackGoodsExample example);

    int deleteByExample(SalesbackGoodsExample example);

    int deleteByPrimaryKey(Integer salesbackGoodsId);

    int insert(SalesbackGoods record);

    int insertSelective(SalesbackGoods record);

    List<SalesbackGoods> selectByExample(SalesbackGoodsExample example);

    SalesbackGoods selectByPrimaryKey(Integer salesbackGoodsId);

    int updateByExampleSelective(@Param("record") SalesbackGoods record, @Param("example") SalesbackGoodsExample example);

    int updateByExample(@Param("record") SalesbackGoods record, @Param("example") SalesbackGoodsExample example);

    int updateByPrimaryKeySelective(SalesbackGoods record);

    int updateByPrimaryKey(SalesbackGoods record);
}