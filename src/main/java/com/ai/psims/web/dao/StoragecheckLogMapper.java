package com.ai.psims.web.dao;

import com.ai.psims.web.model.StoragecheckLog;
import com.ai.psims.web.model.StoragecheckLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoragecheckLogMapper {
    int countByExample(StoragecheckLogExample example);

    int deleteByExample(StoragecheckLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(StoragecheckLog record);

    int insertSelective(StoragecheckLog record);

    List<StoragecheckLog> selectByExample(StoragecheckLogExample example);

    StoragecheckLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") StoragecheckLog record, @Param("example") StoragecheckLogExample example);

    int updateByExample(@Param("record") StoragecheckLog record, @Param("example") StoragecheckLogExample example);

    int updateByPrimaryKeySelective(StoragecheckLog record);

    int updateByPrimaryKey(StoragecheckLog record);
}