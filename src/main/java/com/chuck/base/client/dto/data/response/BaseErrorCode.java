package com.chuck.base.client.dto.data.response;

/**
 *
 * @author Administrator
 * @since 2021/8/27
 * @version 0.0.1
 * @apiNote Value Object
 **/
@Deprecated
public enum BaseErrorCode {
    UNKNOWN_ERROR,

    /** 记录不唯一错误(创建时传入重复参数、修改时修改了唯一标识) */
    MODEL_NOT_UNIQUE,

    /** 参数错误, 方法调用传入的参数有� */
    PARAM_ERROR,

    /** 无数据 */
    MODEL_NOT_FOUND
}
