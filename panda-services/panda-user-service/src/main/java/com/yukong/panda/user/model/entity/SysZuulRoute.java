package com.yukong.panda.user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_zuul_route")
public class SysZuulRoute {
    /**
     * router Id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 路由路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 服务名称
     */
    @TableField(value = "service_id")
    private String serviceId;

    /**
     * url代理
     */
    @TableField(value = "url")
    private String url;

    /**
     * 转发去掉前缀
     */
    @TableField(value = "strip_prefix")
    private String stripPrefix;

    /**
     * 是否重试
     */
    @TableField(value = "retryable")
    private String retryable;

    /**
     * 是否启用
     */
    @TableField(value = "enabled")
    private String enabled;

    /**
     * 敏感请求头
     */
    @TableField(value = "sensitive_headers_list")
    private String sensitiveHeadersList;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableField(value = "del_flag")
    private String delFlag;

    public static final String COL_PATH = "path";

    public static final String COL_SERVICE_ID = "service_id";

    public static final String COL_URL = "url";

    public static final String COL_STRIP_PREFIX = "strip_prefix";

    public static final String COL_RETRYABLE = "retryable";

    public static final String COL_ENABLED = "enabled";

    public static final String COL_SENSITIVE_HEADERS_LIST = "sensitive_headers_list";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DEL_FLAG = "del_flag";
}