package org.cpm.zwl.commons.constrants;

public enum ZwlBaseErrorCode implements ErrorCodeInterface {
	
	UNKNOWN_ERROR("UNKNOWN_ERROR", "unknown error"),
	DUPLICATE_ENTRY("DUPLICATE_ENTRY", "duplication entry"),
	PAGE_NUM_LESS_THAN_ZERO("PAGE_NUM_LESS_THAN_ZERO", "page number can not less than zero"),
	PAGE_SIZE_LESS_THAN_ZERO("PAGE_SIZE_LESS_THAN_ZERO", "page size can not less than zero")
	;
	
	protected String errorCode;
	protected String message;
	
	private ZwlBaseErrorCode(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
}
