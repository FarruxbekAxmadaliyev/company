package com.example.springbootmvc.repository;

import com.example.springbootmvc.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentReposity extends JpaRepository<Department,Integer> {
}
