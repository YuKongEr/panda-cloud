package com.yukong.panda.gen.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: yukong
 * @date: 2018/11/8 09:37
 */
@Data
@TableName("information_schema.tables")
public class TableInfo {

    /**
     * 表名
     */
    @TableId
    private String tableName;

    /**
     * 数据库引擎名
     */
    private String engine;

    /**
     * 表注释
     */
    private String tableComment;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
