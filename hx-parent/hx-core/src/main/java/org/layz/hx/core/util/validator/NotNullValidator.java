package org.layz.hx.core.util.validator;

import org.layz.hx.core.annotation.valid.HxNotNull;
import org.layz.hx.core.exception.HxRuntimeException;
import org.layz.hx.core.pojo.info.FieldValidInfo;
import org.layz.hx.core.util.Assert;

import java.lang.annotation.Annotation;

/**
 * null 校验
 */
public class NotNullValidator implements Validator {
    @Override
    public boolean support(Annotation annotation) {
        return annotation instanceof HxNotNull;
    }

    @Override
    public void validat(Object obj, Annotation annotation, FieldValidInfo fieldValidInfo) throws Throwable {
        Object value = fieldValidInfo.getMethodGet().invoke(obj);
        Assert.isNotNull(value,((HxNotNull)annotation).value());
    }
}
