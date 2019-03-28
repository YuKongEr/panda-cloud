package com.yukong.panda.gateway.service.impl;

import com.google.common.base.Strings;
import com.yukong.panda.common.vo.SysResourceVO;
import com.yukong.panda.gateway.feign.SysResourceService;
import com.yukong.panda.gateway.service.SysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: yukong
 * @date: 2018/11/15 16:52
 */
@Service
@Slf4j
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysResourceService sysResourceService;





    @Override
    public Boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        Object principal = authentication.getPrincipal();
        AtomicBoolean hasPermission = new AtomicBoolean(false);
        List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        if(principal != null){
            if(CollectionUtils.isEmpty(authorities)) {
                return false;
            }
            Set<SysResourceVO> sysResourceVOS = new HashSet<>();
            authorities.stream().forEach( simpleGrantedAuthority -> {
                Set<SysResourceVO> resourceVOS = sysResourceService.listResourceByRole(simpleGrantedAuthority.getAuthority());
                sysResourceVOS.addAll(resourceVOS);
            });
            sysResourceVOS.stream().filter(sysResourceVO ->
                    Strings.isNullOrEmpty(sysResourceVO.getPath()) && antPathMatcher.match(request.getRequestURI(),sysResourceVO.getUrl())
                            && request.getMethod().equalsIgnoreCase(sysResourceVO.getMethod())
            ).findFirst().ifPresent(sysResourceVO -> hasPermission.set(true));
        }

        return hasPermission.get();
    }
}
