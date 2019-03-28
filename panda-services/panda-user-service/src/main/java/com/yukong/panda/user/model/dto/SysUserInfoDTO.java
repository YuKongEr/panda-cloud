package com.yukong.panda.user.model.dto;

import com.yukong.panda.user.model.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author: yukong
 * @date: 2018/10/17 17:10
 * @description:
 */
@Data
public class SysUserInfoDTO {

    private SysUser sysUser;

    private List<String> roles;

    private List<String> permissions;
}
