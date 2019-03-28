package com.yukong.panda.auth.controller;

import com.yukong.panda.auth.query.OAuth2AccessTokenQuery;
import com.yukong.panda.common.constants.CommonConstants;
import com.yukong.panda.common.constants.SecurityConstants;
import com.yukong.panda.common.service.RedisService;
import com.yukong.panda.common.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;
import java.util.*;

/**
 * @author yukong
 * @date 2018年10月31日13:23:22
 */
@RestController
public class AuthController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private RedisTokenStore redisTokenStore;

    @DeleteMapping("/token/{token}")
    public ApiResult<Boolean> removeAccessToken(@PathVariable("token") String token) {
        return new ApiResult<>(consumerTokenServices.revokeToken(token));
    }

    @GetMapping("/token")
    public ApiResult<Collection<OAuth2AccessToken>> readAllToken() {
        return new ApiResult<>(redisTokenStore.findTokensByClientId(SecurityConstants.CLOUD));
    }

    @GetMapping("/token/page")
    public ApiResult getTokenList(OAuth2AccessTokenQuery oAuth2AccessTokenQuery) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        oAuth2AccessTokenQuery.setRecords((List)redisTemplate.opsForList().range(CommonConstants.PANDA_REDIS_LIST_LEY, oAuth2AccessTokenQuery.getStart(), oAuth2AccessTokenQuery.getEnd()));
        List<OAuth2AccessToken> all = (List)redisTemplate.opsForList().range(CommonConstants.PANDA_REDIS_LIST_LEY, 0, -1);
        if(all != null){
            oAuth2AccessTokenQuery.setTotal(all.size());
        }
        return new ApiResult(oAuth2AccessTokenQuery);
    }

}
