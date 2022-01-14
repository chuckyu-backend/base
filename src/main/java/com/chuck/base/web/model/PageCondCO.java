package com.chuck.base.web.model;

import lombok.Value;

/**
 * @author Chuck
 * @since 4/22/2021
 * @version 0.0.1
 *     <p>THINKING 不使用基本类型的原因
 */
@Value
public class PageCondCo {
  /** 第几页，从1开始 */
  private Integer num;
  /** 每页大小 */
  private Integer size;
}
