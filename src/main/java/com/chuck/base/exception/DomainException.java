package com.chuck.base.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 在某些业务异常（Code）比较少的情况下，可以对每一个异常提供一个异常类
 *
 * <p>这里采用对每一个异常提供一个Code
 *
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DomainException extends RuntimeException {

  private final int code;

  private DomainException(int code, String msg) {
    super(msg);
    this.code = code;
  }

  private DomainException(int code, String msg, Throwable e) {
    super(msg, e);
    this.code = code;
  }

  public static DomainException of(int code) {
    return new DomainException(code, "");
  }

  public static DomainException of(int code, String msg) {
    return new DomainException(code, msg);
  }

  public static DomainException of(int code, String msg, Throwable e) {
    return new DomainException(code, msg, e);
  }
  // ==========模型相关业务异常
  public static final int MODEL_NOT_FOUND = 1404;
  // 412	Precondition Failed	客户端请求信息的先决条件错误
  public static final int MODEL_CREATE_WITH_ID = 1412;
  public static final int MODEL_CREATE_REPEAT = 1012;

  //  ==========文件相关业务异常
  public static final int FILE_NOT_FOUND = 2404;
  public static final int FILE_PERMISSION_DENY = 2001;
}
