package org.layz.hx.core.enums.type;

public interface TypeEnum {
    /**
     * 获取值
     * @return
     */
    Integer getValue();

    /**
     * 获取名称
     * @return
     */
    String getName();

    boolean equalValue(Integer value);
}
