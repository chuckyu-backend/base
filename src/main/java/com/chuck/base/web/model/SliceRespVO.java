package com.chuck.base.web.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description
 * @author: Chuck
 * @date: 1/12/2022 1:57 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliceRespVO<T> {
  /** 当前页码 */
  private Integer num;
  /** 每页数量 */
  private Integer size;

  private List<T> data;
}
