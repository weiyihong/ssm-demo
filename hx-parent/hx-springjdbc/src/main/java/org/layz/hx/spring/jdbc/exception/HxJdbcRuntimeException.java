package org.layz.hx.spring.jdbc.exception;

import org.layz.hx.core.exception.HxRuntimeException;

public class HxJdbcRuntimeException extends HxRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3792637000288178656L;
	public HxJdbcRuntimeException() {
        super();
    }

    public HxJdbcRuntimeException(String message) {
        super(message);
    }

    public HxJdbcRuntimeException(Throwable cause) {
    	super(null,cause);
    }
    
    public HxJdbcRuntimeException(String message, Throwable cause) {
    	super(null, message, cause);
    }
    
    public HxJdbcRuntimeException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
