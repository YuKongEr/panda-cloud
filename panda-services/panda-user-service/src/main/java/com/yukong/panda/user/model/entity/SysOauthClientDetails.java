package com.yukong.panda.user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * oauth2客户端资源认证表
 * </p>
 *
 * @author yukong
 * @since 2018-12-13
 */
@Data
@Accessors(chain = true)
public class SysOauthClientDetails {

    private static final long serialVersionUID = 1L;

    @TableId(value = "client_id", type = IdType.INPUT)
    private String clientId;

    private String resourcesIds;

    private String clientSecret;

    private String scope;

    /**
     * 授权认证类型
     */
    private String authorizedGrantTypes;

    /**
     * 重定向uri
     */
    private String webServerRedirectUri;

    /**
     * 权限
     */
    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionInformation;

    @TableField(value = "autoapprove")
    private String autoapprove;


}
