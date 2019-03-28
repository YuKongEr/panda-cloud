package com.yukong.panda.gateway.feign;

import com.yukong.panda.common.constants.PandaServiceNameConstants;
import com.yukong.panda.common.vo.SysResourceVO;
import com.yukong.panda.gateway.feign.fallback.SysResourceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @author: yukong
 * @date: 2018/11/15 16:36
 */
@FeignClient(value = PandaServiceNameConstants.PANDA_USER_SERVICE, fallback = SysResourceFallback.class)
public interface SysResourceService {

    /**
     * 根据角色查询资源信息
     * @param roleCode
     * @return
     */
    @GetMapping("/resource/role/{roleCode}")
    Set<SysResourceVO> listResourceByRole(@PathVariable("roleCode") String roleCode);

}
