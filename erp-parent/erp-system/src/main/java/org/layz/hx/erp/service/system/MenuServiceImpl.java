package org.layz.hx.erp.service.system;

import org.layz.hx.core.enums.type.DisableEnum;
import org.layz.hx.core.enums.type.RoleTypeEnum;
import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.entity.system.Menu;
import org.layz.hx.erp.domain.entity.system.Role;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.erp.repository.jdbc.system.MenuDao;
import org.layz.hx.erp.repository.mapper.system.MenuMapper;
import org.layz.hx.spring.jdbc.repository.BaseDao;
import org.layz.hx.spring.jdbc.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleService roleService;
    @Override
    public BaseDao<Menu> getBaseDao() {
        return menuDao;
    }

    @Override
    public List<Menu> queryRoleMenu(Long roleId) {
        LOGGER.debug("roleId: {}", roleId);
        Assert.isNotNull(roleId, ErpSystemEnum.ROLE_IS_ERROR);
        Role role = roleService.findById(roleId);
        Assert.isNotNull(role,ErpSystemEnum.ROLE_IS_ERROR);
        Assert.isTrue(DisableEnum.ENABLE.equalValue(role.getDeleted()), ErpSystemEnum.ROLE_IS_ERROR);
        Integer roleType = role.getRoleType();
        List<Menu> result;
        if(RoleTypeEnum.SUPER_ADMIN.equalValue(roleType)) {
            result = menuMapper.findSystemMenu(role.getSysId());
        } else if (RoleTypeEnum.SYSTEM_ADMIN.equalValue(roleType)) {
            result = menuMapper.findSystemMenu(role.getSysId());
        } else if (RoleTypeEnum.OTHER_ROLE.equalValue(roleType)) {
            result = menuMapper.findRoleMenu(roleId);
        } else {
            result = null;
        }
        if(null == result) {
            return null;
        }
        result = result.stream().filter(o -> DisableEnum.ENABLE.equalValue(o.getDeleted()))
                .collect(Collectors.toList());
        return result;
    }
}
