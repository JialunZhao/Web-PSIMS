package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbStoragecheckMapper {
    int countByExample(TbStoragecheckExample example);

    int deleteByExample(TbStoragecheckExample example);

    int deleteByPrimaryKey(Integer storageId);

    int insert(TbStoragecheck record);

    int insertSelective(TbStoragecheck record);

    List<TbStoragecheck> selectByExample(TbStoragecheckExample example);

    TbStoragecheck selectByPrimaryKey(Integer storageId);

    int updateByExampleSelective(@Param("record") TbStoragecheck record, @Param("example") TbStoragecheckExample example);

    int updateByExample(@Param("record") TbStoragecheck record, @Param("example") TbStoragecheckExample example);

    int updateByPrimaryKeySelective(TbStoragecheck record);

    int updateByPrimaryKey(TbStoragecheck record);
}