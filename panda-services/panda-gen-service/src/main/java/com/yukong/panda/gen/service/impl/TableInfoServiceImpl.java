package com.yukong.panda.gen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yukong.panda.gen.mapper.TableInfoMapper;
import com.yukong.panda.gen.model.entity.TableInfo;
import com.yukong.panda.gen.model.query.TableInfoQuery;
import com.yukong.panda.gen.service.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yukong
 * @date: 2018/11/8 10:05
 */
@Service
public class TableInfoServiceImpl extends ServiceImpl<TableInfoMapper, TableInfo> implements TableInfoService {

    @Autowired
    private TableInfoMapper tableInfoMapper;

    @Override
    public TableInfoQuery pageByQuery(TableInfoQuery query) {
        tableInfoMapper.pageByQuery(query);
        return query;
    }

    @Override
    public TableInfo getOne(String tableName) {
        return tableInfoMapper.getOne(tableName);
    }
}
