package org.layz.hx.erp.domain.entity.system.dto;

import org.layz.hx.core.annotation.valid.HxNotBlank;
import org.layz.hx.core.annotation.valid.HxNotNull;
import org.layz.hx.core.annotation.valid.HxTrim;

public class LoginDto {
    @HxNotNull("用户名不能为空")
    @HxNotBlank("请输入用户名")
    @HxTrim
    private String userCode;
    @HxNotNull("密码不能为空")
    @HxNotBlank("请输入密码")
    @HxTrim
    private String passWord;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
