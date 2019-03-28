package com.yukong.panda.user.service.impl;

import com.yukong.panda.user.PandaUserServiceApplicationTests;
import com.yukong.panda.user.service.SysResourceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: yukong
 * @date: 2018/10/17 15:45
 * @description:
 */
public class SysResourceServiceImplTest extends PandaUserServiceApplicationTests {


    @Autowired
    private SysResourceService sysResourceService;

    @Test
    public void getMenuTreeByRoleCodes() {
    }

    @Test
    public void getAllResourceTree() {
        System.out.println(sysResourceService.getAllResourceTree());
    }
}