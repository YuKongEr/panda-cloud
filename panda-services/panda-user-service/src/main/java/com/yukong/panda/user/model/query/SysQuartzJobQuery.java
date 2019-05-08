package com.yukong.panda.user.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yukong.panda.user.model.entity.SysQuartzJob;
import com.yukong.panda.user.model.entity.SysZuulRoute;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yukong
 * @date 2019-04-24 11:30
 */
@Data
@EqualsAndHashCode
public class SysQuartzJobQuery extends Page<SysQuartzJob> {

    /**
     * 任务类名
     */
    private String jobClassName;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 删除标记
     */
    private Integer status;

    /**
     * 删除标记
     */
    private Integer delFlag;

}
