package com.yukong.panda.gen.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yukong.panda.gen.model.entity.TableInfo;
import lombok.Data;

/**
 * @author: yukong
 * @date: 2018/11/8 10:01
 */
@Data
public class TableInfoQuery extends Page<TableInfo> {

    private String tableName;


}
