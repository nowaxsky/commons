package org.cpm.zwl.commons.exceptions;

import org.cpm.zwl.commons.constrants.ErrorCodeInterface;

public class ZwlBaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3888912013545648810L;
	protected String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ZwlBaseException(String errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = errorCode;
	}
	
	public ZwlBaseException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public ZwlBaseException(ErrorCodeInterface errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode.getErrorCode();
	}
	
	public ZwlBaseException(String message) {
		super(message);
	}
	
	public ZwlBaseException(ErrorCodeInterface errorCode, Throwable throwable) {
		super(errorCode.getMessage(), throwable);
		this.errorCode = errorCode.getErrorCode();
	}
	
}
