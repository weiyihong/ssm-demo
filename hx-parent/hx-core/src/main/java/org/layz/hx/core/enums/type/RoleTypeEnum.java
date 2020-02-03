package org.layz.hx.core.enums.type;

public enum RoleTypeEnum implements TypeEnum {
    SUPER_ADMIN(0,"超级管理员"),
    SYSTEM_ADMIN(1,"系统管理员"),
    OTHER_ROLE(2,"普通角色");

    private Integer value;
    private String name;

    RoleTypeEnum(Integer value,String name) {
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
