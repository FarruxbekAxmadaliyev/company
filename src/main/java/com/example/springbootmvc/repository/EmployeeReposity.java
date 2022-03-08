package com.example.springbootmvc.repository;

import com.example.springbootmvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReposity extends JpaRepository<Employee,Integer> {
}
