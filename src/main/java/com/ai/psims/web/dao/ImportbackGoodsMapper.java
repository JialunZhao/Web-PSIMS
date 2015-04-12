package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportbackGoods;
import com.ai.psims.web.model.ImportbackGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImportbackGoodsMapper {
    int countByExample(ImportbackGoodsExample example);

    int deleteByExample(ImportbackGoodsExample example);

    int deleteByPrimaryKey(Integer importbackGoodsId);

    int insert(ImportbackGoods record);

    int insertSelective(ImportbackGoods record);

    List<ImportbackGoods> selectByExample(ImportbackGoodsExample example);

    ImportbackGoods selectByPrimaryKey(Integer importbackGoodsId);

    int updateByExampleSelective(@Param("record") ImportbackGoods record, @Param("example") ImportbackGoodsExample example);

    int updateByExample(@Param("record") ImportbackGoods record, @Param("example") ImportbackGoodsExample example);

    int updateByPrimaryKeySelective(ImportbackGoods record);

    int updateByPrimaryKey(ImportbackGoods record);
}