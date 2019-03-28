package com.yukong.panda.gateway.config;


import com.yukong.panda.common.config.IgnoreUrlPropertiesConfig;
import com.yukong.panda.common.constants.SecurityConstants;
import com.yukong.panda.gateway.auth.endpoint.AuthExceptionEntryPoint;
import com.yukong.panda.gateway.auth.handler.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author: yukong
 * @date: 2018/10/11 11:12
 * @description: oauth2资源服务器配置
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private IgnoreUrlPropertiesConfig ignoreUrlPropertiesConfig;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;


    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }


    /**
     * 配置token存储到redis中
     * @return
     */
    @Bean
    public RedisTokenStore redisTokenStore() {
        RedisTokenStore store = new RedisTokenStore(redisConnectionFactory);
        store.setPrefix(SecurityConstants.CLOUD_PREFIX);
        return store;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config =  http.authorizeRequests();
        ignoreUrlPropertiesConfig.getUrls().forEach( e ->{
            config.antMatchers(e).permitAll();
        });
        // 前后分离 先发出options 放行
        config.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .anyRequest().authenticated();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(redisTokenStore())
                .accessDeniedHandler(customAccessDeniedHandler)
                .authenticationEntryPoint(new AuthExceptionEntryPoint());
    }
}
