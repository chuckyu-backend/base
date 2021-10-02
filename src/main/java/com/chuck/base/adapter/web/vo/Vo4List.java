package com.chuck.base.adapter.web.vo;

import javax.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 * @since 2021/8/20
 * @version 0.0.1
 * @apiNote Value Object
 **/
@Getter
@Setter
public abstract class Vo4List {
//    //@Schema(value = "数据库主键", example = "1")
    @DecimalMin("1")
    private int id;
}
