package com.yukong.panda.user.model.query;

import com.yukong.panda.user.model.entity.SysDict;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;



/**
 * @author yukong
 */
@Data
public class SysDictQuery extends  Page<SysDict> {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 字典描述
     */
    private String desc;
    /**
     * 字典值
     */
    private String value;
    /**
     * 上层id  定义默认是-1
     */
    private Integer parentId;
    /**
     * 权重
     */
    private Integer sortOrder;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date modifyTime;
    /**
     * 是否删除 1-删除，0-未删除
     */
    private String delFlag;

}
