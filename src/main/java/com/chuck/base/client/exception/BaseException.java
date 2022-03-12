package com.chuck.base.client.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

/**
 * 在某些业务异常（Code）比较少的情况下，可以对每一个异常提供一个异常类
 * 
 * 这里采用对每一个异常提供一个Code
 * 
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 **/
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    private final String msg;

    private final int code;

    public BaseException(String msg) {
        // 为什么要调用super(msg)，默认调用super()不行吗？ THINKING
        super(msg);
        this.msg = msg;
        this.code = SERVER_CODE;
    }

    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = SERVER_CODE;
    }

    public BaseException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public static final int SERVER_CODE = 500;

    public static final int MODEL_NOT_FOUND = 1000;

    public static final int MODEL_CREATE_WITH_ID = 1001;

    public static final int MODEL_CREATE_REPEAT = 1002;

    public static final int FILE_UPLOAD_ERROR = 11001;

    public static final int FILE_EMPTY = 11002;

    public static final int FILE_STORE_OUTSIDE_CURRENT_DIRECTORY = 11003;

    public static final int FILE_READ_ERROR = 11004;
}
