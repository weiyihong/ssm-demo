package org.layz.hx.web.wrapper.system;

import org.layz.hx.erp.domain.delegate.system.MenuDelegate;
import org.layz.hx.erp.domain.entity.system.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuWrapperImpl implements MenuWrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuWrapperImpl.class);
    @Autowired
    private MenuDelegate menuDelegate;

    @Override
    public Menu queryRoleMenu(Long roleId) {
        LOGGER.debug("roleId: {}", roleId);
        return menuDelegate.queryRoleMenu(roleId);
    }

    @Override
    public List<String> queryRolePath(Long roleId) {
        LOGGER.debug("roleId: {}", roleId);
        return menuDelegate.queryRolePath(roleId);
    }
}
