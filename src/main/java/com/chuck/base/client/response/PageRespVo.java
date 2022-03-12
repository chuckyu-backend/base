package com.chuck.base.client.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * THINKING 是否有直接JPA的Page对象
 *
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PageRespVo<T> extends SliceRespVo<T> {

  /** 记录总数 */
  private Long totalSize;
  /** 页码总数 */
  private Integer totalNums;
}
