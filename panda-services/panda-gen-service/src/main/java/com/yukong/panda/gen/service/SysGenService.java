package com.yukong.panda.gen.service;

import com.yukong.panda.gen.model.dto.BuildConfigDTO;

import java.util.List;

/**
 * @author: yukong
 * @date: 2018/11/8 14:45
 */
public interface SysGenService {

    /**
     * 根据表名生成代码
     * @param buildConfigDTO
     * @return
     */
    byte[] genCodeByTableName(BuildConfigDTO buildConfigDTO);

}
