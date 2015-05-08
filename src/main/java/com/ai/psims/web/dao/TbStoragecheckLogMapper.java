package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbStoragecheckLog;
import com.ai.psims.web.model.TbStoragecheckLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbStoragecheckLogMapper {
    int countByExample(TbStoragecheckLogExample example);

    int deleteByExample(TbStoragecheckLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbStoragecheckLog record);

    int insertSelective(TbStoragecheckLog record);

    List<TbStoragecheckLog> selectByExample(TbStoragecheckLogExample example);

    TbStoragecheckLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbStoragecheckLog record, @Param("example") TbStoragecheckLogExample example);

    int updateByExample(@Param("record") TbStoragecheckLog record, @Param("example") TbStoragecheckLogExample example);

    int updateByPrimaryKeySelective(TbStoragecheckLog record);

    int updateByPrimaryKey(TbStoragecheckLog record);
}