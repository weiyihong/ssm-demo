package org.layz.hx.core.annotation.valid;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HxNotBlank {

    /**
     * 提示信息
     */
    String value() default "";
}
