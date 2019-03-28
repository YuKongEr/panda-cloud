package com.yukong.panda.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yukong.panda.user.PandaUserServiceApplicationTests;
import com.yukong.panda.user.model.entity.SysRole;
import com.yukong.panda.user.model.query.SysRoleQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: yukong
 * @date: 2018/11/1 17:32
 */
@Slf4j
public class SysRoleMapperTest extends PandaUserServiceApplicationTests {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Test
    public void pageByQuery() {

        SysRoleQuery query = new SysRoleQuery();
        query.setRoleName("用户");
        sysRoleMapper.pageByQuery(query);
        log.info(query.toString());
        Assert.assertNotEquals(0, query.getSize());
    }
}