package org.layz.hx.erp.domain.enums.response;

import org.layz.hx.core.enums.ResponseEnum;

public enum  ErpSystemEnum implements ResponseEnum {
    NOY_LOGIN_ERROR("200001","您未登录，请先登录！",FAIL),
    LOGIN_INPUT_ERROR("200002","登录失败，用户名或密码错误！",FAIL),
    USER_NOT_EXSIST("200003","用户信息不存在！",FAIL),
    USER_ROLE_EMPTY("200004","您的权限不足！",FAIL),
    USER_ID_ISNULL("200005","用户名不能为空！",FAIL),
    ROLE_ID_ISNULL("200006","请选择角色！",FAIL),
    ROLE_NO_CHANGE("200007","您未切换角色！",FAIL),
    ROLE_IS_ERROR("200008","您没有该角色权限！",FAIL);
    private String code;
    private String msg;
    private Integer success;
    ErpSystemEnum(String code, String msg, Integer success){
        this.code = code;
        this.msg = msg;
        this.success = success;
    }
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public Integer getSuccess(){
        return success;
    }
}
