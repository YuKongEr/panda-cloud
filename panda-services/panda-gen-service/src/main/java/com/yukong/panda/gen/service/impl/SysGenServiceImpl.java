package com.yukong.panda.gen.service.impl;

import com.yukong.panda.gen.mapper.ColumnInfoMapper;
import com.yukong.panda.gen.mapper.TableInfoMapper;
import com.yukong.panda.gen.model.dto.BuildConfigDTO;
import com.yukong.panda.gen.model.entity.ColumnInfo;
import com.yukong.panda.gen.model.entity.TableInfo;
import com.yukong.panda.gen.service.SysGenService;
import com.yukong.panda.gen.util.GenUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * @author: yukong
 * @date: 2018/11/8 14:48
 */
@Service
public class SysGenServiceImpl implements SysGenService {

    @Autowired
    private TableInfoMapper tableInfoMapper;

    @Autowired
    private ColumnInfoMapper columnInfoMapper;

    @Override
    public byte[] genCodeByTableName(BuildConfigDTO buildConfigDTO) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : buildConfigDTO.getTableName()) {
            //查询表信息
           TableInfo table = tableInfoMapper.getOne(tableName);
            //查询列信息
            List<ColumnInfo> columns = columnInfoMapper.listByTableName(tableName);
            //生成代码
            GenUtil.generatorCode(buildConfigDTO,table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();

    }
}
