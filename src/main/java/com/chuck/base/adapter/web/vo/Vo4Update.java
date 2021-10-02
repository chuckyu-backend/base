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
public abstract class Vo4Update {
//    //@Schema(value = "数据库主键，新增自动生成", example = "1")
    @DecimalMin("1")
    private int id;
}
