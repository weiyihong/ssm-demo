package org.layz.hx.core.exception;

import org.layz.hx.core.enums.ResponseEnum;

/**
 * 通用异常
 */
public class HxRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2748181292439428383L;
	/**
	 * 异常信息
	 */
	private String messgae;
	/**
	 * 异常编码
	 */
	private String code;

    public HxRuntimeException() {
        super();
    }

    public HxRuntimeException(String message) {
        this.messgae = message;
    }

    public HxRuntimeException(Throwable cause) {
        this(null,cause);
    }
    
    public HxRuntimeException(String message, Throwable cause) {
        this(null, message, cause);
    }
    
    public HxRuntimeException(String code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.messgae = message;
    }

    public HxRuntimeException(ResponseEnum response) {
        this.code = response.getCode();
        this.messgae = response.getMsg();
    }

    @Override
    public String getMessage() {
    	return this.messgae;
    }
    
    public String getCode() {
		return code;
	}
    
    public void setCode(String code) {
		this.code = code;
	}

}
