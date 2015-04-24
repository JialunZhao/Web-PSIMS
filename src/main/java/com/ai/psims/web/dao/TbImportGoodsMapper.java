package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbImportGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbImportGoodsMapper {
    int countByExample(TbImportGoodsExample example);

    int deleteByExample(TbImportGoodsExample example);

    int deleteByPrimaryKey(Integer importGoodsId);

    int insert(TbImportGoods record);

    int insertSelective(TbImportGoods record);

    List<TbImportGoods> selectByExample(TbImportGoodsExample example);

    TbImportGoods selectByPrimaryKey(Integer importGoodsId);

    int updateByExampleSelective(@Param("record") TbImportGoods record, @Param("example") TbImportGoodsExample example);

    int updateByExample(@Param("record") TbImportGoods record, @Param("example") TbImportGoodsExample example);

    int updateByPrimaryKeySelective(TbImportGoods record);

    int updateByPrimaryKey(TbImportGoods record);
}