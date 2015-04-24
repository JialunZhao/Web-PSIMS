package com.ai.psims.web.dao;

import com.ai.psims.web.model.Importback;
import com.ai.psims.web.model.ImportbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImportbackMapper {
    int countByExample(ImportbackExample example);

    int deleteByExample(ImportbackExample example);

    int deleteByPrimaryKey(String importbackSerialNumber);

    int insert(Importback record);

    int insertSelective(Importback record);

    List<Importback> selectByExample(ImportbackExample example);

    Importback selectByPrimaryKey(String importbackSerialNumber);

    int updateByExampleSelective(@Param("record") Importback record, @Param("example") ImportbackExample example);

    int updateByExample(@Param("record") Importback record, @Param("example") ImportbackExample example);

    int updateByPrimaryKeySelective(Importback record);

    int updateByPrimaryKey(Importback record);
}