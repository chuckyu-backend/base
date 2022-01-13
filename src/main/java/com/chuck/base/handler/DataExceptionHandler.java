package com.chuck.base.handler;

import com.chuck.base.adapter.BaseResponse;
import com.querydsl.core.NonUniqueResultException;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
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
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  @ExceptionHandler(NonUniqueResultException.class)
  public BaseResponse<Void> onBaseException(NonUniqueResultException e) {
    log.error(e.getMessage());
    return BaseResponse.error(
        "数据异常，返回多条数据：" + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE.value());
  }

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
}
