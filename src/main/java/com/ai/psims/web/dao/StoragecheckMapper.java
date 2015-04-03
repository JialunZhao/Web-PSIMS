package com.ai.psims.web.dao;

import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoragecheckMapper extends SelectIdMapper{
    int countByExample(StoragecheckExample example);

    int deleteByExample(StoragecheckExample example);

    int insert(Storagecheck record);

    int insertSelective(Storagecheck record);

    List<Storagecheck> selectByExample(StoragecheckExample example);

    int updateByExampleSelective(@Param("record") Storagecheck record, @Param("example") StoragecheckExample example);

    int updateByExample(@Param("record") Storagecheck record, @Param("example") StoragecheckExample example);
}