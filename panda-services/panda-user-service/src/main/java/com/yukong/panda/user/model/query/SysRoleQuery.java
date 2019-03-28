package com.yukong.panda.user.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yukong.panda.user.model.entity.SysRole;
import lombok.Data;

/**
 * @author: yukong
 * @date: 2018/11/1 17:20
 */
@Data
public class SysRoleQuery extends Page<SysRole> {


    /**
     * 角色code用于springsecurity角色标识码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

}
