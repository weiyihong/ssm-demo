package org.layz.hx.core.pojo.info;

import org.layz.hx.core.util.validator.Validator;

import java.lang.annotation.Annotation;
import java.util.Map;

public class FieldValidInfo extends FieldInfo{

    private Map<Annotation, Validator> validatorMap;

    public Map<Annotation, Validator> getValidatorMap() {
        return validatorMap;
    }

    public void setValidatorMap(Map<Annotation, Validator> validatorMap) {
        this.validatorMap = validatorMap;
    }
}
