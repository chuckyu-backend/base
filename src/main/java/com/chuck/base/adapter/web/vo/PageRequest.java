package com.chuck.base.adapter.web.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Chuck
 * @version 0.0.1
 *          <p>
 *          <p>
 *          THINKING 不使用基本类型的原因
 * @since 4/22/2021
 **/
@Getter
@Setter
@AllArgsConstructor
public class PageRequest {

    /**
     * 第几页，从0开始
     */
    private int pageNum;
    /**
     * 每页大小
     */
    private int pageSize;
}
