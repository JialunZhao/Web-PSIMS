package com.ai.psims.web.dao;

import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoragecheckMapper {
    int countByExample(StoragecheckExample example);

    int deleteByExample(StoragecheckExample example);

    int deleteByPrimaryKey(Integer storageId);

    int insert(Storagecheck record);

    int insertSelective(Storagecheck record);

    List<Storagecheck> selectByExample(StoragecheckExample example);

    Storagecheck selectByPrimaryKey(Integer storageId);

    int updateByExampleSelective(@Param("record") Storagecheck record, @Param("example") StoragecheckExample example);

    int updateByExample(@Param("record") Storagecheck record, @Param("example") StoragecheckExample example);

    int updateByPrimaryKeySelective(Storagecheck record);

    int updateByPrimaryKey(Storagecheck record);
}