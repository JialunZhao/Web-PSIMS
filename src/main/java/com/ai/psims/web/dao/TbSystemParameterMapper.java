package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSystemParameterMapper {
    int countByExample(TbSystemParameterExample example);

    int deleteByExample(TbSystemParameterExample example);

    int deleteByPrimaryKey(Integer paramId);

    int insert(TbSystemParameter record);

    int insertSelective(TbSystemParameter record);

    List<TbSystemParameter> selectByExample(TbSystemParameterExample example);

    TbSystemParameter selectByPrimaryKey(Integer paramId);

    int updateByExampleSelective(@Param("record") TbSystemParameter record, @Param("example") TbSystemParameterExample example);

    int updateByExample(@Param("record") TbSystemParameter record, @Param("example") TbSystemParameterExample example);

    int updateByPrimaryKeySelective(TbSystemParameter record);

    int updateByPrimaryKey(TbSystemParameter record);
}