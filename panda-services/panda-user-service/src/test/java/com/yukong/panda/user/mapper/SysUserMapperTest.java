package com.yukong.panda.user.mapper;

import com.yukong.panda.user.PandaUserServiceApplicationTests;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: yukong
 * @date: 2018/10/16 17:48
 * @description:
 */
public class SysUserMapperTest extends PandaUserServiceApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void loadUserByUsername() {
        System.out.println(sysUserMapper.loadUserByUsername("yukong"));
    }
}