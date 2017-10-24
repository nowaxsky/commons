package org.cpm.zwl.commons.response;

/**
 * restful object 
 * @author CPM
 *
 * @param <T>
 */
public class JsonResponse<T> {

	private boolean isSuccess;
	private String errorCode;
	private String message;
	private T values;
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getValues() {
		return values;
	}
	public void setValues(T values) {
		this.values = values;
	}
	
}
