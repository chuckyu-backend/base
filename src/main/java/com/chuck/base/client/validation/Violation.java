package com.chuck.base.client.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Chuck
 * @version 0.0.1
 * @apiNote
 * @since 7/31/2021
 **/
@Getter
@Setter
@AllArgsConstructor
public class Violation {

    private final String fieldName;

    private final String message;

}