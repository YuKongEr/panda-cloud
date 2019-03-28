package com.yukong.panda.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yukong.panda.user.model.dto.SysRoleDTO;
import com.yukong.panda.user.model.entity.SysRole;
import com.yukong.panda.user.model.query.SysRoleQuery;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author yukong
 * @since 2018-10-16
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {


    /**
     * 分页查询
     * @param query
     * @return
     */
    IPage<SysRole> pageByQuery(SysRoleQuery query);


}
