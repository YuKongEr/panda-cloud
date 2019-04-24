package com.yukong.panda.user.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yukong.panda.user.model.entity.SysDict;
import com.yukong.panda.user.model.entity.SysOauthClientDetails;
import lombok.Data;

/**
 * @author yukong
 * @date 2019-04-22 11:29
 */
@Data
public class SysOauthClientDetailsQuery  extends Page<SysOauthClientDetails> {

    private String clientId;

    private String resourcesIds;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

}
