package com.chuck.base.web.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Chuck
 * @since 4/22/2021
 * @version 0.0.1
 * 
 * 
 *          THINKING 不使用基本类型的原因
 **/
@Getter
@Setter
public class PageReq {
    /**
     * 第几页，从1开始
     */
    private Integer pageNum;
    /**
     * 每页大小
     */
    private Integer pageSize;

}
