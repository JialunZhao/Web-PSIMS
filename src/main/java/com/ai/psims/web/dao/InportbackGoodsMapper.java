package com.ai.psims.web.dao;

import com.ai.psims.web.model.InportbackGoods;
import com.ai.psims.web.model.InportbackGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InportbackGoodsMapper {
    int countByExample(InportbackGoodsExample example);

    int deleteByExample(InportbackGoodsExample example);

    int deleteByPrimaryKey(String importbackGoodsId);

    int insert(InportbackGoods record);

    int insertSelective(InportbackGoods record);

    List<InportbackGoods> selectByExample(InportbackGoodsExample example);

    InportbackGoods selectByPrimaryKey(String importbackGoodsId);

    int updateByExampleSelective(@Param("record") InportbackGoods record, @Param("example") InportbackGoodsExample example);

    int updateByExample(@Param("record") InportbackGoods record, @Param("example") InportbackGoodsExample example);

    int updateByPrimaryKeySelective(InportbackGoods record);

    int updateByPrimaryKey(InportbackGoods record);
}