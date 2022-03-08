package com.example.springbootmvc.servis;

import com.example.springbootmvc.dto.ApiResponse;
import com.example.springbootmvc.dto.DepartmentDTO;
import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.entity.Department;
import com.example.springbootmvc.repository.CompnyRepository;
import com.example.springbootmvc.repository.DepartmentReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServis {
@Autowired
    DepartmentReposity departmentReposity;
@Autowired
    CompnyRepository compnyRepository;
public ApiResponse add(DepartmentDTO departmentDTO){
    Optional<Company> byId = compnyRepository.findById(departmentDTO.getCompanyId());
    if (byId.isEmpty()) return new ApiResponse("bunday id yo'q",false);
    Company company=byId.get();
    Department department=new Department();
    department.setName(departmentDTO.getName());
    department.setCompany(company);
    Department save =departmentReposity.save(department);
    return new ApiResponse("saved",true,save);
    }

    public ApiResponse update(Integer id, DepartmentDTO departmentDTO){
        Department byId = departmentReposity.getById(id);
        Company company=compnyRepository.getById(departmentDTO.getCompanyId());
        byId.setId(id);
        byId.setName(departmentDTO.getName());
        byId.setCompany(company);
        Department save = departmentReposity.save(byId);
        return new ApiResponse("saved",true,save);

    }



}
