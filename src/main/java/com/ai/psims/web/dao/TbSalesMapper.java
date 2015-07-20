package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbSales;
import com.ai.psims.web.model.TbSalesExample;
import com.ai.psims.web.model.TbSalesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSalesMapper {
    int countByExample(TbSalesExample example);

    int deleteByExample(TbSalesExample example);

    int deleteByPrimaryKey(TbSalesKey key);

    int insert(TbSales record);

    int insertSelective(TbSales record);

    List<TbSales> selectByExample(TbSalesExample example);

    TbSales selectByPrimaryKey(TbSalesKey key);

    int updateByExampleSelective(@Param("record") TbSales record, @Param("example") TbSalesExample example);

    int updateByExample(@Param("record") TbSales record, @Param("example") TbSalesExample example);

    int updateByPrimaryKeySelective(TbSales record);

    int updateByPrimaryKey(TbSales record);
}