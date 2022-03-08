package com.example.springbootmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class  DepartmentDTO {
    private String name;
    private Integer companyId;
}
