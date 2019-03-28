package com.yukong.panda.auth.mobile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yukong.panda.common.enums.ResponseCodeEnum;
import com.yukong.panda.common.util.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestValidator;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author: yukong
 * @date: 2018/12/12 17:41
 */
@Slf4j
@Component
public class MobileAuthenticationFailHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;


    private final static String UTF8 = "utf-8";
    private final static String CONTENT_TYPE = "application/json";


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败 原因: {}", exception.getMessage());
        response.setCharacterEncoding(UTF8);
        response.setContentType(CONTENT_TYPE);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(new ApiResult<>(exception.getMessage(), ResponseCodeEnum.FAIL)));
    }
}
