package com.chuck.base.web.model;

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
public class BaseResponse<T, R> {
    /**
     * 状态码
     */
    private T code;
    /**
     * 描述信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private R data;
}
