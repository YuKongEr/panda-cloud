package com.yukong.panda.user.mapper;

import com.yukong.panda.user.PandaUserServiceApplicationTests;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: yukong
 * @date: 2018/10/17 14:44
 * @description:
 */
public class SysResourceMapperTest extends PandaUserServiceApplicationTests {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Test
    public void findResourceByRoleCode() {
        Assert.isNull(sysResourceMapper.findResourceByRoleCode("ROLE_ADMIN"));

    }
}