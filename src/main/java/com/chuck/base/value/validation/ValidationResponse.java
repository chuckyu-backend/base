package com.chuck.base.value.validation;

import com.chuck.base.value.response.BaseResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Chuck
 * @version 0.0.1
 * @apiNote
 * @since 7/31/2021
 */
@Getter
@Setter
public class ValidationResponse extends BaseResponse<List<Validation>> {
  /** 状态码 */
  private List<Validation> data;

  public ValidationResponse() {
    this.data = new ArrayList<>();
  }
}
