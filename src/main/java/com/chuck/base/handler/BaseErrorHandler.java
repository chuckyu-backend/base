package com.chuck.base.handler;

import com.chuck.base.adapter.BaseResponse;
import com.chuck.base.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseErrorHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse<Void> onHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return BaseResponse.error(e.getMessage(),HttpStatus.BAD_REQUEST.value());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BaseException.class)
    public BaseResponse<Void> onBaseException(BaseException e){
        return BaseResponse.error(e.getMsg(),HttpStatus.BAD_REQUEST.value());
    }
}
