package com.chuck.base.value.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Chuck
 * @version 0.0.1
 *     <p>T表示状态码类型，一般为int、String
 *     <p>R表示数据类型
 * @since 4/22/2021
 */
@Getter
@Setter
public class BaseResponse<T> {

  private static final int SERVER_ERROR = 500;

  private static final int CLIENT_ERROR = 400;
  /** 状态码 */
  private int code = 200;
  /** 描述信息 */
  private String message;

  // --------------------------------------------------------------------------------构造器
  /** 返回数据 */
  private T data;

  /**
   * 1、客户端校验不通过直接通过Advice返回了，只会在Advice中调用；
   *
   * <p>2、服务器错误理论上很少见，如果出现了，也应该是通过Advice返回，所以也是只在Advice中调用；
   *
   * @param data
   * @return
   */
  public static <T> BaseResponse<T> ok(T data) {
    BaseResponse<T> r = new BaseResponse<>();
    r.setData(data);
    return r;
  }

  public static <T> BaseResponse<T> ok(String message, T data) {
    BaseResponse<T> r = new BaseResponse<>();
    r.setMessage(message);
    r.setData(data);
    return r;
  }

  public static BaseResponse<Void> ok() {
    return new BaseResponse<>();
  }

  public static BaseResponse<Void> error(String message, int code) {
    BaseResponse<Void> r = new BaseResponse<>();
    r.setMessage(message);
    r.setCode(code);
    return r;
  }
}
