package com.hk.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 
 * @author huangkai
 * @version V1.0
 */
public class MMGenCastException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2449402888015263024L;
	
	private Throwable throwable;

	public MMGenCastException(Throwable e) {
		this.throwable = e;
	}
	
	@Override
	public String getMessage() {
		return throwable.getMessage();
	}

	@Override
	public String getLocalizedMessage() {
		return throwable.getLocalizedMessage();
	}

	@Override
	public synchronized Throwable initCause(Throwable cause) {
		return throwable.initCause(cause);
	}

	@Override
	public String toString() {
		return throwable.toString();
	}

	@Override
	public void printStackTrace() {
		throwable.printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		throwable.printStackTrace(s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		throwable.printStackTrace(s);
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return super.fillInStackTrace();
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		return throwable.getStackTrace();
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		throwable.setStackTrace(stackTrace);
	}

}
