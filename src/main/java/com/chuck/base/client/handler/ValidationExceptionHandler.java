package com.chuck.base.client.handler;

import com.chuck.base.client.response.BaseResponse;
import com.chuck.base.client.response.ValidationErrorResponse;
import com.chuck.base.client.validation.Violation;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Chuck
 * @version 0.0.1
 * @apiNote
 * @since 7/31/2021
 */
@RestControllerAdvice
@Slf4j
public class ValidationExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
    ValidationErrorResponse error = new ValidationErrorResponse();
    for (ConstraintViolation violation : e.getConstraintViolations()) {
      error
          .getData()
          .add(new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
      log.error(violation.getPropertyPath().toString() + "：" + violation.getMessage());
    }
    return error;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    log.error(e.getMessage());
    ValidationErrorResponse error = new ValidationErrorResponse();
    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
      error.getData().add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
      log.error(fieldError.getField() + "：" + fieldError.getDefaultMessage());
    }
    return error;
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public BaseResponse<Void> onHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }


}
