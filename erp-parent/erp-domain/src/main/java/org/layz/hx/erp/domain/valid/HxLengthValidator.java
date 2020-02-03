package org.layz.hx.erp.domain.valid;

import org.layz.hx.core.pojo.info.FieldValidInfo;
import org.layz.hx.core.util.Assert;
import org.layz.hx.core.util.validator.Validator;
import org.layz.hx.erp.domain.valid.annotation.HxLength;

import java.lang.annotation.Annotation;

public class HxLengthValidator implements Validator {
    @Override
    public boolean support(Annotation annotation) {
        return annotation instanceof HxLength;
    }

    @Override
    public void validat(Object obj, Annotation annotation, FieldValidInfo fieldValidInfo) throws Throwable {
        Object value = fieldValidInfo.getMethodGet().invoke(obj);
        if(null == value) {
            return;
        }
        int length = ((String) value).trim().length();
        HxLength hxLength = (HxLength) annotation;
        int min = hxLength.min();
        int max = hxLength.max();
        Assert.isFalse((min >= 0 && min > length), hxLength.value());
        Assert.isFalse((max >= 0 && max < length), hxLength.value());
    }
}
