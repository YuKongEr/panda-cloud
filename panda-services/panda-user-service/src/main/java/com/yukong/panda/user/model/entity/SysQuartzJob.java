package com.yukong.panda.user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author yukong
 */
@Data
@TableName(value = "sys_quartz_job")
public class SysQuartzJob {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * cron表达式
     */
    @TableField(value = "cron_expression")
    private String cronExpression;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * job类路径
     */
    @TableField(value = "job_class_name")
    private String jobClassName;

    /**
     * 参数
     */
    @TableField(value = "parameter")
    private String parameter;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 删除标记
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

    public static final String COL_CRON_EXPRESSION = "cron_expression";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_JOB_CLASS_NAME = "job_class_name";

    public static final String COL_PARAMETER = "parameter";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_DEL_FLAG = "del_flag";
}