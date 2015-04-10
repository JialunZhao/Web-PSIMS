package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.model.ImportGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImportGoodsMapper {
    int countByExample(ImportGoodsExample example);

    int deleteByExample(ImportGoodsExample example);

    int deleteByPrimaryKey(Integer importGoodsId);

    int insert(ImportGoods record);

    int insertSelective(ImportGoods record);

    List<ImportGoods> selectByExample(ImportGoodsExample example);

    ImportGoods selectByPrimaryKey(Integer importGoodsId);

    int updateByExampleSelective(@Param("record") ImportGoods record, @Param("example") ImportGoodsExample example);

    int updateByExample(@Param("record") ImportGoods record, @Param("example") ImportGoodsExample example);

    int updateByPrimaryKeySelective(ImportGoods record);

    int updateByPrimaryKey(ImportGoods record);
}