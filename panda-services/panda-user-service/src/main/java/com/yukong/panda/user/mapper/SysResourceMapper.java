package com.yukong.panda.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yukong.panda.user.model.entity.SysResource;

import java.util.List;

/**
 * <p>
 * 资源表(菜单与按钮) Mapper 接口
 * </p>
 *
 * @author yukong
 * @since 2018-10-16
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    /**
     * 根据角色code查询资源集合
     * @param roleCode
     * @return
     */
    List<SysResource> findResourceByRoleCode(String roleCode);

}
