package org.cpm.zwl.commons.utils;

import org.cpm.zwl.commons.constrants.ErrorCodeInterface;
import org.cpm.zwl.commons.response.JsonResponse;

/**
 * json response
 * 
 * @author Mailu
 *
 */
public class JsonResponseUtil {

  public static <T> JsonResponse<T> getSuccess(T values, String message) {
    JsonResponse<T> response = new JsonResponse<T>();
    response.setSuccess(true);
    response.setValues(values);
    response.setMessage(message);
    return response;
  }

  @SuppressWarnings("rawtypes")
  public static JsonResponse getFail(String errorCode, String message) {
    JsonResponse<Object> response = new JsonResponse<Object>();
    response.setSuccess(false);
    response.setErrorCode(errorCode);
    response.setMessage(message);
    return response;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static JsonResponse getFail(ErrorCodeInterface errorCode, String message) {
    JsonResponse<Object> response = getFail(errorCode.getErrorCode(), message);
    return response;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static <T> JsonResponse getFail(ErrorCodeInterface errorCode, String message, T values) {
    JsonResponse<Object> response = getFail(errorCode.getErrorCode(), message);
    response.setValues(values);
    return response;
  }
}
