package com.yukong.panda.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yukong.panda.user.model.entity.SysLog;
import com.yukong.panda.user.model.entity.SysRole;
import com.yukong.panda.user.model.query.SysLogQuery;

/**
 * <p>
 * 角色资源关联表 Mapper 接口
 * </p>
 *
 * @author yukong
 * @since 2018-10-16
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

    /**
     * 日志信息分页查询
     * @param query
     */
    IPage<SysLog> pageByQuery(SysLogQuery query);
}
