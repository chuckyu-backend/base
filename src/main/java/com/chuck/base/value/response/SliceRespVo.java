package com.chuck.base.value.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: Chuck
 * @date: 1/12/2022 1:57 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliceRespVo<T> {
  /** 当前页码 */
  private Integer num = 0;
  /** 每页数量 */
  private Integer size = 0;

  private List<T> data = new ArrayList<>();
}
