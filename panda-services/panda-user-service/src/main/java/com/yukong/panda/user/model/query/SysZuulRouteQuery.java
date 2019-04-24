package com.yukong.panda.user.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yukong.panda.user.model.entity.SysZuulRoute;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yukong
 * @date 2019-04-24 11:30
 */
@Data
@EqualsAndHashCode
public class SysZuulRouteQuery extends Page<SysZuulRoute> {

    /**
     * 服务名称
     */
    private String serviceId;

    /**
     * 删除标记
     */
    private Integer delFlag;

}
