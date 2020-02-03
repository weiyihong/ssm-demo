package org.layz.hx.core.enums.type;

public enum DisableEnum implements TypeEnum {
    DISABLE(0,"无效"),
    ENABLE(1,"有效");

    private Integer value;
    private String name;

    DisableEnum(Integer value, String name) {
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
