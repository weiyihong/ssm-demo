package org.layz.hx.erp.domain.valid.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HxLength {

    /**
     * 提示信息
     */
    String value() default "";

    /**
     * 最小长度 小于 0 忽略
     */
    int min() default -1;
    /**
     * 最大长度 小于 0 忽略
     */
    int max() default -1;
}
