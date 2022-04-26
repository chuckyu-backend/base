package com.chuck.base.domain.exception;

import lombok.*;

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
@Data
@EqualsAndHashCode(callSuper = false)
public class DomainException extends RuntimeException {

    private final String msg;

    private int code = 500;

    public DomainException(String msg) {
        // 为什么要调用super(msg)，默认调用super()不行吗？ THINKING
        super(msg);
        this.msg = msg;
    }

    public DomainException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public DomainException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public DomainException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
