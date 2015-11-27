package com.hk.exception;

/**
 * 运行时异常
 * 
 * @author fanlychie
 * @since 1.0.0
 */
public class FileAssistantCastException extends RuntimeException {
	
	private static final long serialVersionUID = 2384386701675995791L;

	public FileAssistantCastException(String message) {
		super(message);
	}

	public FileAssistantCastException(Throwable e) {
		super(e);
	}

	public FileAssistantCastException(String message, Throwable e) {
		super(message, e);
	}
}