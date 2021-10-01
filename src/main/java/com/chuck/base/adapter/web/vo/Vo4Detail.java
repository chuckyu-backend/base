package com.chuck.base.adapter.web.vo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vo4Detail {
    @ApiModelProperty(value = "数据库主键", example = "1")
    @DecimalMin("1")
    private int id;
}
