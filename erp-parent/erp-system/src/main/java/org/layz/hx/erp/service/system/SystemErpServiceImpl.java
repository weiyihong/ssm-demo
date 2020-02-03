package org.layz.hx.erp.service.system;

import org.layz.hx.core.enums.type.DisableEnum;
import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.entity.system.Role;
import org.layz.hx.erp.domain.entity.system.SystemErp;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.erp.repository.jdbc.system.SystemErpDao;
import org.layz.hx.spring.jdbc.repository.BaseDao;
import org.layz.hx.spring.jdbc.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SystemErpServiceImpl extends BaseServiceImpl<SystemErp> implements SystemErpService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemErpServiceImpl.class);
    @Autowired
    private SystemErpDao systemErpDao;
    @Autowired
    private RoleService roleService;

    @Override
    public BaseDao<SystemErp> getBaseDao() {
        return systemErpDao;
    }

    @Override
    public List<SystemErp> queryUserAuth(Long userId) {
        LOGGER.debug("userId: {}", userId);
        Assert.isNotNull(userId, ErpSystemEnum.NOY_LOGIN_ERROR);
        List<Role> roleList = roleService.queryUserRole(userId, DisableEnum.ENABLE);
        Assert.isNotEmpty(roleList, ErpSystemEnum.USER_ROLE_EMPTY);
        // 系统信息查询
        List<Long> systermIdList = roleList.stream().map(Role::getSysId).distinct().collect(Collectors.toList());
        List<SystemErp> systemErpList = systemErpDao.findByIds(systermIdList)
                .stream().filter(o -> DisableEnum.ENABLE.equalValue(o.getDeleted())).collect(Collectors.toList());
        Assert.isNotEmpty(systemErpList, ErpSystemEnum.USER_ROLE_EMPTY);
        // 数据分装
        Map<Long, List<Role>> roleMap = roleList.stream().collect(Collectors.groupingBy(Role::getSysId));
        for (SystemErp systemErp : systemErpList) {
            systemErp.setRoleList(roleMap.get(systemErp.getId()));
        }
        return systemErpList;
    }
}
