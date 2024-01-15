package com.gs.webflux.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InputFailedValidationResponse {

    private int errorCode;
    private int input;
    private String errorMessage;
}