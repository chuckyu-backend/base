package com.chuck.base.web.model;

import lombok.Data;

/**
 * THINKING 是否有直接JPA的Page对象
 *
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 */
@Data
public class PageRespVO<T> extends SliceRespVO<T> {

  /** 记录总数 */
  private Long totalSize;
  /** 页码总数 */
  private Integer totalNums;
}
