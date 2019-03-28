package com.yukong.panda.gen.mapper;

import com.yukong.panda.gen.model.entity.ColumnInfo;
import com.yukong.panda.gen.model.entity.TableInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: yukong
 * @date: 2018/11/8 10:29
 */
public interface ColumnInfoMapper {

    /**
     * 查询单个表的列详细信息
     * @param tableName
     * @return
     */
    List<ColumnInfo> listByTableName(@Param("tableName") String tableName);

}
