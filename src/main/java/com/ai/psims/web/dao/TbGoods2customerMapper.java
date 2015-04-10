package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbGoods2customer;
import com.ai.psims.web.model.TbGoods2customerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoods2customerMapper {
    int countByExample(TbGoods2customerExample example);

    int deleteByExample(TbGoods2customerExample example);

    int deleteByPrimaryKey(Integer goods2customerId);

    int insert(TbGoods2customer record);

    int insertSelective(TbGoods2customer record);

    List<TbGoods2customer> selectByExample(TbGoods2customerExample example);

    TbGoods2customer selectByPrimaryKey(Integer goods2customerId);

    int updateByExampleSelective(@Param("record") TbGoods2customer record, @Param("example") TbGoods2customerExample example);

    int updateByExample(@Param("record") TbGoods2customer record, @Param("example") TbGoods2customerExample example);

    int updateByPrimaryKeySelective(TbGoods2customer record);

    int updateByPrimaryKey(TbGoods2customer record);
}