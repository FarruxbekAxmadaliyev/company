package com.example.springbootmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String messgae;
    private boolean response;
    private Object object;

    public ApiResponse(String messgae, boolean response) {
        this.messgae = messgae;
        this.response = response;
    }
}
