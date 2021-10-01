package com.chuck.base.adapter.web.vo;

import com.chuck.base.adapter.BaseResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Chuck
 * @version 0.0.1
 * @apiNote
 * @since 7/31/2021
 **/
@Getter
@Setter
public class ValidationErrorResponse extends BaseResponse<List<Violation>> {
    /**
     * 状态码
     */
    private final int code = HttpStatus.BAD_REQUEST.value();

    private List<Violation> data = new ArrayList<>();
}
