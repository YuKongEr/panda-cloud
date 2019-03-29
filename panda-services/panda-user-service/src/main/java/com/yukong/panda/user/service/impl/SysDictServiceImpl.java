package com.yukong.panda.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yukong.panda.common.base.service.impl.BaseServiceImpl;
import com.yukong.panda.user.mapper.SysDictMapper;
import com.yukong.panda.user.model.entity.SysDict;
import com.yukong.panda.user.service.SysDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yukong
 * @date 2019-01-23 10:57
 */
@Service
public class SysDictServiceImpl extends BaseServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    private static final Integer TOP_PARENT_ID = -1;

    @Override
    public List<SysDict> getTopDictListByDesc(String desc) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(SysDict::getParentId, TOP_PARENT_ID)
                .like(StringUtils.isNotBlank(desc), SysDict::getDesc, desc);
        return super.baseMapper.selectList(queryWrapper);
    }
}
