package org.layz.hx.erp.delegate.system;

import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.layz.hx.core.enums.type.MenuTypeEnum;
import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.delegate.system.MenuDelegate;
import org.layz.hx.erp.domain.entity.system.Menu;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.erp.service.system.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuDelegateImpl implements MenuDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuDelegateImpl.class);
    @Autowired
    private MenuService menuService;
    @Override
    public Menu queryRoleMenu(Long roleId) {
        LOGGER.debug("roleId: {}", roleId);
        List<Menu> list = menuService.queryRoleMenu(roleId);
        Assert.isNotEmpty(list, ErpSystemEnum.USER_ROLE_EMPTY);
        list = list.stream().filter(o -> !MenuTypeEnum.AUTH_MENU.equalValue(o.getType())).collect(Collectors.toList());
        Map<Long, List<Menu>> map = list.stream().collect(Collectors.groupingBy(Menu::getParentId));
        Menu result = null;
        for (Menu menu : list) {
            menu.setCode(null);
            menu.setSort(null);
            menu.setRemark(null);
            menu.setHelpUrl(null);
            menu.setDeleted(null);
            menu.setCreatedBy(null);
            menu.setLastModifiedBy(null);
            menu.setCreatedDate(null);
            menu.setLastModifiedDate(null);
            menu.setChildren(map.get(menu.getId()));
            if(MenuTypeEnum.ROOT_MENU.equalValue(menu.getType())){
                result = menu;
            }
        }
        return result;
    }

    @Override
    public List<String> queryRolePath(Long roleId) {
        LOGGER.debug("roleId: {}", roleId);
        List<Menu> list = menuService.queryRoleMenu(roleId);
        Assert.isNotEmpty(list, ErpSystemEnum.USER_ROLE_EMPTY);
        List<String> result = new ArrayList<>();
        for (Menu menu : list) {
            Integer type = menu.getType();
            if(!MenuTypeEnum.AUTH_MENU.equalValue(type)) {
                continue;
            }
            String url = menu.getUrl();
            if(StringUtils.isNotBlank(url)){
                result.add(url);
            }
            String helpUrl = menu.getHelpUrl();
            if(StringUtils.isNotBlank(helpUrl)) {
                for (String path : helpUrl.split(",")) {
                    result.add(path);
                }
            }
        }
        result = result.stream().distinct().collect(Collectors.toList());
        return result;
    }
}
