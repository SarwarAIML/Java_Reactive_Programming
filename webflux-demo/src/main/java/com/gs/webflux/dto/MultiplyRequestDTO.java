package com.gs.webflux.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MultiplyRequestDTO {
    private int first;
    private int second;
}