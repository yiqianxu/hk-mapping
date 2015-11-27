package com.hk.exception;

/**
 * 
 * @author huangkai
 * @version V1.0
 */
public class MetaDataCastException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8077615746694248364L;
	
	public MetaDataCastException(String message) {
		super(message);
	}
	
	public MetaDataCastException(Throwable e) {
		super(e);
	}
	
	public MetaDataCastException(String message, Throwable e) {
		super(message, e);
	}
}
