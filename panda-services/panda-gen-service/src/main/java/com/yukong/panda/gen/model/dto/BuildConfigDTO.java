package com.yukong.panda.gen.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: yukong
 * @date: 2018/11/8 15:52
 */
@Data
public class BuildConfigDTO {

    private String genType;

    private List<String> tableName;

    /**
     * 包名
     */
    private String packageName;

    /**
     * query类的包名
     */
    private String queryPackageName;

    /**
     * service类包名
     */
    private String servicePackageName;

    /**
     * serviceApi类包名
     */
    private String serviceApiPackageName;

    /**
     * dao的包名
     */
    private String daoPackageName;

    /**
     * mapper类包名
     */
    private String mapperPackageName;

    /**
     * controller类包名
     */
    private String controllerPackageName;


    /**
     * 作者名称
     */
    private String authorName;

}
