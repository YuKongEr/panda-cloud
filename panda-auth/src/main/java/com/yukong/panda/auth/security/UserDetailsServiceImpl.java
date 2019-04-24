package com.yukong.panda.auth.security;

import com.yukong.panda.auth.service.SysUserService;
import com.yukong.panda.common.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author: yukong
 * @date: 2018/10/9 10:05
 * @description: security UserDetailsService实现类
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private SysUserService sysUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserVo sysUserVo = sysUserService.loadUserByUsername(username);
        if(sysUserVo == null){
            throw new UsernameNotFoundException("当前用户尚未注册");
        }
        return new UserDetailsImpl(sysUserService.loadUserByUsername(username));
    }
}
