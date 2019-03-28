package com.yukong.panda.gen.service.impl;

import com.yukong.panda.gen.model.entity.TableInfo;
import com.yukong.panda.gen.model.query.TableInfoQuery;
import com.yukong.panda.gen.service.TableInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author: yukong
 * @date: 2018/11/8 10:07
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TableInfoServiceImplTest {

    @Autowired
    private TableInfoService tableInfoService;

    @Test
    public void pageByQuery() {
        TableInfoQuery query = new TableInfoQuery();
        tableInfoService.pageByQuery(query);
        log.info(query.toString());
    }

    @Test
    public  void getOne() {
        TableInfo  tableInfo = tableInfoService.getById("sys_user");
        log.info(tableInfo.toString());
    }
}