package com.yukong.panda.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yukong.panda.common.constants.CommonConstants;
import com.yukong.panda.common.enums.DataStatusEnum;
import com.yukong.panda.common.enums.ResourceTypeEnum;
import com.yukong.panda.user.model.dto.SysResourceTree;
import com.yukong.panda.user.model.entity.SysResource;
import com.yukong.panda.user.mapper.SysResourceMapper;
import com.yukong.panda.user.service.SysResourceService;
import com.yukong.panda.user.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yukong
 * @date: 2018/10/17 14:57
 * @description: 系统资源服务实现类
 */
@Service
public class SysResourceServiceImpl  extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResourceTree> getMenuTreeByRoleCodes(List<String> roleCodes) {
        // 1、首选获取所有角色的资源集合
        Set<SysResource> sysResources = getSysResourceRoleCodes(roleCodes);
        // 2、找出类型为菜单类型的 然后排序
        List<SysResource> newSysResource = sysResources.stream()
                .filter(sysResource -> ResourceTypeEnum.MENU.getCode().equals(sysResource.getType()))
                .sorted(Comparator.comparingInt(SysResource::getSort))
                .collect(Collectors.toList());
        // 3、构建树
        return TreeUtil.list2Tree(newSysResource, CommonConstants.TREE_ROOT);
    }

    @Override
    public Set<SysResource> getSysResourceRoleCodes(List<String> roleCodes) {
        Set<SysResource> sysResources = new HashSet<>();
        roleCodes.forEach( roleCode -> {
            sysResources.addAll(sysResourceMapper.findResourceByRoleCode(roleCode));
        });
        return sysResources;
    }

    @Override
    public List<SysResourceTree> getAllResourceTree() {
        QueryWrapper<SysResource> query  = new QueryWrapper();
        query.lambda().eq(SysResource::getDelFlag, DataStatusEnum.NORMAL.getCode());
        List<SysResource> sysResources = sysResourceMapper.selectList(query);
        return TreeUtil.list2Tree(sysResources, CommonConstants.TREE_ROOT);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deleteResource(Integer id) {
        // 伪删除
        SysResource sysResource = super.getById(id);
        sysResource.setDelFlag(DataStatusEnum.LOCK.getCode());
        super.updateById(sysResource);

        SysResource resource = new SysResource();
        resource.setDelFlag(DataStatusEnum.LOCK.getCode());
        UpdateWrapper<SysResource> wrapper = new UpdateWrapper<>();
        wrapper.lambda().eq(SysResource::getParentId, sysResource.getId());
        super.update(resource, wrapper);
        return true;
    }

    @Override
    public List<SysResource> findResourceByRoleCode(String roleCode) {
        return sysResourceMapper.findResourceByRoleCode(roleCode);
    }
}
