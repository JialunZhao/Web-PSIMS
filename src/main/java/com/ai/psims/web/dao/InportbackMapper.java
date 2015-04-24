package com.ai.psims.web.dao;

import com.ai.psims.web.model.Inportback;
import com.ai.psims.web.model.InportbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InportbackMapper {
    int countByExample(InportbackExample example);

    int deleteByExample(InportbackExample example);

    int deleteByPrimaryKey(String importbackSerialNumber);

    int insert(Inportback record);

    int insertSelective(Inportback record);

    List<Inportback> selectByExample(InportbackExample example);

    Inportback selectByPrimaryKey(String importbackSerialNumber);

    int updateByExampleSelective(@Param("record") Inportback record, @Param("example") InportbackExample example);

    int updateByExample(@Param("record") Inportback record, @Param("example") InportbackExample example);

    int updateByPrimaryKeySelective(Inportback record);

    int updateByPrimaryKey(Inportback record);
}