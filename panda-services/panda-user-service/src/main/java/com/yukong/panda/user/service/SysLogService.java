package com.yukong.panda.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yukong.panda.common.vo.SysUserVo;
import com.yukong.panda.user.model.dto.SysUserInfoDTO;
import com.yukong.panda.user.model.entity.SysLog;
import com.yukong.panda.user.model.entity.SysUser;
import com.yukong.panda.user.model.query.SysLogQuery;
import com.yukong.panda.user.model.query.SysRoleQuery;
import com.yukong.panda.user.model.query.SysUserVoQuery;

import java.util.List;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author yukong
 * @since 2018-10-08
 */
public interface SysLogService extends IService<SysLog> {

    /**
     * 分页条件查询
     * @param query
     * @return
     */
    SysLogQuery pageByQuery(SysLogQuery query);

}
