package com.chuck.base.response;

import lombok.Data;

/**
 * @author Chuck
 * @since 4/22/2021
 * @version 0.0.1
 * 
 *          T表示状态码类型，一般为int、String
 * 
 *          R表示数据类型
 **/
@Data
public class BaseResponse<T> {
    /**
     * 状态码
     */
    private int code = 200;
    /**
     * 描述信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    // --------------------------------------------------------------------------------构造器
    public static BaseResponse<Object> error() {
        return error(SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static BaseResponse<Object> error(String msg) {
        return error(SERVER_ERROR, msg);
    }

    public static BaseResponse<Object> error(int code, String msg) {
        BaseResponse<Object> r = new BaseResponse<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static BaseResponse<Object> ok(String msg) {
        BaseResponse<Object> r = new BaseResponse<>();
        r.setMsg(msg);
        return r;
    }

    public static BaseResponse<Object> ok(Object data) {
        BaseResponse<Object> r = new BaseResponse<>();
        r.setData(data);
        return r;
    }

    public static BaseResponse<Object> ok() {
        return new BaseResponse<>();
    }
    // --------------------------------------------------------------------------------构造器End

    private static final int SERVER_ERROR = 500;
}
