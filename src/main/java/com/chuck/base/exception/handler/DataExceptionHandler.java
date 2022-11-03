package com.chuck.base.exception.handler;

import com.chuck.base.value.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
/**
 * DataExceptionHandler
 *
 * @description
 * @author Chuck
 * @date 1/13/2022 2:38 PM
 */
@RestControllerAdvice
@Slf4j
public class DataExceptionHandler {

  @ResponseBody
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> onIllegalArgumentException(IllegalArgumentException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }

  @ResponseBody
  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> onNoSuchElementException(NoSuchElementException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }

  @ResponseBody
  @ExceptionHandler(PropertyReferenceException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> onPropertyReferenceException(PropertyReferenceException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }

  @ResponseBody
  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> onSQLIntegrityConstraintViolationException(
      SQLIntegrityConstraintViolationException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }
}
