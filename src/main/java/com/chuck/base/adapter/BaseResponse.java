package com.chuck.base.adapter;
// package ?;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Chuck
 * @version 0.0.1
 * <p>
 * T表示状态码类型，一般为int、String
 * <p>
 * R表示数据类型
 * @since 4/22/2021
 **/
@Getter
@Setter
public class BaseResponse<T> {

    private static final int SERVER_ERROR = 500;
    /**
     * 状态码
     */
    private int code = 200;
    /**
     * 描述信息
     */
    private String msg;

    // --------------------------------------------------------------------------------构造器
    /**
     * 返回数据
     */
    private T data;

    public static <T> BaseResponse<T> error() {
        return error("未知异常，请联系管理员", SERVER_ERROR);
    }

    public static <T> BaseResponse<T> error(String msg) {
        return error(msg, SERVER_ERROR);
    }

    public static <T> BaseResponse<T> error(String msg, int code) {
        return error(msg,code,null);
    }
    public static <T> BaseResponse<T> error(String msg,int code,T errors) {
        BaseResponse<T> r = new BaseResponse<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(errors);
        return r;
    }

    public static <T> BaseResponse<T> ok(T data) {
        BaseResponse<T> r = new BaseResponse<>();
        r.setData(data);
        return r;
    }

    public static <T> BaseResponse<T> ok(String msg, T data) {
        BaseResponse<T> r = new BaseResponse<>();
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    // --------------------------------------------------------------------------------构造器End

    public static BaseResponse<Void> ok() {
        return new BaseResponse<>();
    }
}
