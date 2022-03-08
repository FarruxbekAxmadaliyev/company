package com.example.springbootmvc.servis;

import com.example.springbootmvc.dto.ApiResponse;
import com.example.springbootmvc.dto.EmployeeDTO;
import com.example.springbootmvc.entity.Department;
import com.example.springbootmvc.entity.Employee;
import com.example.springbootmvc.repository.DepartmentReposity;
import com.example.springbootmvc.repository.EmployeeReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeServic {
    @Autowired
    DepartmentReposity departmentReposity;
    @Autowired
    EmployeeReposity employeeReposity;

    public ApiResponse add(EmployeeDTO employeeDTO){
        Optional<Department> byId = departmentReposity.findById(employeeDTO.getDepartmentId());
        if (byId.isEmpty()) return new ApiResponse("bunday id yo'q",false);
        Department department=byId.get();
        Employee employe=new Employee();
        employe.setFullname(employeeDTO.getFullname());
        employe.setPhone(employeeDTO.getPhone());
        employe.setDepartment(department);
        Employee save=employeeReposity.save(employe);

        return new ApiResponse("saved",true,save);
    }



    public ApiResponse update(Integer id,EmployeeDTO employeeDTO){
        Employee byId = employeeReposity.getById(id);
        Department department=departmentReposity.getById(employeeDTO.getDepartmentId());
        byId.setId(id);
        byId.setFullname(employeeDTO.getFullname());
        byId.setPhone(employeeDTO.getPhone());
        byId.setDepartment(department);
        Employee save =employeeReposity.save(byId);
        return new ApiResponse("saved",true,save);

    }


}
