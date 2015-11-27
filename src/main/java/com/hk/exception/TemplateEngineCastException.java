package com.hk.exception;

/**
 * 运行时异常
 * 
 * @author huangkai
 * @since 1.0.0
 */
public class TemplateEngineCastException extends RuntimeException {
	
	private static final long serialVersionUID = 2682914847694078346L;

	public TemplateEngineCastException(String message) {
		super(message);
	}

	public TemplateEngineCastException(Throwable e) {
		super(e);
	}

	public TemplateEngineCastException(String message, Throwable e) {
		super(message, e);
	}

}