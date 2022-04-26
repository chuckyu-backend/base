package com.chuck.base.client.dto.data.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 违反规则：Violation
 *
 * @author Chuck
 * @version 0.0.1
 * @apiNote
 * @since 7/31/2021
 **/
@Getter
@Setter
@AllArgsConstructor
public class Validation {

    private final String fieldName;

    private final String message;

}