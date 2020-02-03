package org.layz.hx.core.enums.type;

public enum MenuTypeEnum implements TypeEnum {
    ROOT_MENU(0,"根菜单"),
    NODE_MENU(1,"节点菜单"),
    TREE_MENU(2,"页面菜单"),
    AUTH_MENU(3,"权限菜单");

    private Integer value;
    private String name;

    MenuTypeEnum(Integer value,String name) {
        this.value = value;
        this.name = name;
    }
    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equalValue(Integer value) {
        return this.value.equals(value);
    }
}
