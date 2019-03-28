package com.yukong.panda.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yukong.panda.common.constants.CommonConstants;
import com.yukong.panda.common.enums.DataStatusEnum;
import com.yukong.panda.common.enums.ResourceTypeEnum;
import com.yukong.panda.user.mapper.SysLogMapper;
import com.yukong.panda.user.mapper.SysResourceMapper;
import com.yukong.panda.user.model.dto.SysResourceTree;
import com.yukong.panda.user.model.entity.SysLog;
import com.yukong.panda.user.model.entity.SysResource;
import com.yukong.panda.user.model.query.SysLogQuery;
import com.yukong.panda.user.model.query.SysRoleQuery;
import com.yukong.panda.user.service.SysLogService;
import com.yukong.panda.user.service.SysResourceService;
import com.yukong.panda.user.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: yukong
 * @date: 2018/11/14 14:57
 * @description: 系统日志服务实现类
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysLogQuery pageByQuery(SysLogQuery query) {
        query.setDesc("create_time");
        sysLogMapper.pageByQuery(query);
        return query;
    }
}
