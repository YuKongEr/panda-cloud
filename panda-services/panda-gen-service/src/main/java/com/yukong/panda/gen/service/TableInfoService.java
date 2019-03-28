package com.yukong.panda.gen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yukong.panda.gen.model.entity.TableInfo;
import com.yukong.panda.gen.model.query.TableInfoQuery;
import org.apache.ibatis.annotations.Param;

/**
 * @author: yukong
 * @date: 2018/11/8 10:04
 */
public interface TableInfoService extends IService<TableInfo> {

    /**
     * 分页查询表信息
     * @param query
     * @return
     */
    TableInfoQuery pageByQuery(TableInfoQuery query);

    /**
     * 查询单个表信息
     * @param tableName
     * @return
     */
    TableInfo getOne(String tableName);

}
