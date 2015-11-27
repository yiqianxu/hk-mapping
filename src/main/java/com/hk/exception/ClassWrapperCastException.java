package com.hk.exception;

/**
 * 运行时异常
 * 
 * @author huangkai
 * @since 1.0.0
 */
public class ClassWrapperCastException extends RuntimeException {
	
	private static final long serialVersionUID = -2129960440385424588L;

	public ClassWrapperCastException(String message) {
		super(message);
	}

	public ClassWrapperCastException(Throwable e) {
		super(e);
	}

	public ClassWrapperCastException(String message, Throwable e) {
		super(message, e);
	}

}