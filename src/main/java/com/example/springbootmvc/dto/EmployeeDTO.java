package com.example.springbootmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private String fullname;
    private String phone;
    private Integer departmentId;
}
