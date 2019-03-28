package com.yukong.panda.user.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yukong.panda.common.vo.SysUserVo;
import lombok.Data;

/**
 * @author: yukong
 * @date: 2018/11/5 14:02
 */
@Data
public class SysUserVoQuery extends Page<SysUserVo> {

    /**
     * 用户名
     */
    private String username;

}
