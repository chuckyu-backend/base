package com.chuck.base.client.response;

import javax.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vo4Detail {
//    @Scheme(value = "数据库主键", example = "1")
    @DecimalMin("1")
    private int id;
}
