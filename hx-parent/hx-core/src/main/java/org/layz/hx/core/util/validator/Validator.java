package org.layz.hx.core.util.validator;

import org.layz.hx.core.pojo.info.FieldValidInfo;

import java.lang.annotation.Annotation;

public interface Validator {
    /**
     * 支持的注解
     * @param annotation
     * @return
     */
    boolean support(Annotation annotation);

    /**
     * 数据校验
     * @param obj
     * @param annotation
     * @param fieldValidInfo
     */
    void validat(Object obj, Annotation annotation, FieldValidInfo fieldValidInfo) throws Throwable;
}
