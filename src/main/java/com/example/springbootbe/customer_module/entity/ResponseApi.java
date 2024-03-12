package com.example.springbootbe.customer_module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi {
    private Boolean status;
    private String message;
    private Object content;
}
