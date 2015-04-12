package com.ai.psims.web.dao;

import com.ai.psims.web.model.Salesback;
import com.ai.psims.web.model.SalesbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesbackMapper {
    int countByExample(SalesbackExample example);

    int deleteByExample(SalesbackExample example);

    int deleteByPrimaryKey(String salesbackSerialNumber);

    int insert(Salesback record);

    int insertSelective(Salesback record);

    List<Salesback> selectByExample(SalesbackExample example);

    Salesback selectByPrimaryKey(String salesbackSerialNumber);
    
	String selectSalesSerialNumber(String salesbackSerialNumber);

    int updateByExampleSelective(@Param("record") Salesback record, @Param("example") SalesbackExample example);

    int updateByExample(@Param("record") Salesback record, @Param("example") SalesbackExample example);

    int updateByPrimaryKeySelective(Salesback record);

    int updateByPrimaryKey(Salesback record);
}