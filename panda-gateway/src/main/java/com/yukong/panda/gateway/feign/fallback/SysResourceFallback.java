package com.yukong.panda.gateway.feign.fallback;

import com.yukong.panda.common.vo.SysResourceVO;
import com.yukong.panda.gateway.feign.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * @author: yukong
 * @date: 2018/11/15 16:37
 */
@Slf4j
@Service
public class SysResourceFallback implements SysResourceService {
    @Override
    public Set<SysResourceVO> listResourceByRole(String roleCode) {
        log.error("调用【panda-user-service】服务接口【/resource/role/{}】异常", roleCode);
        return Collections.emptySet();
    }
}
