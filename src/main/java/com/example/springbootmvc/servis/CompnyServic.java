package com.example.springbootmvc.servis;

import com.example.springbootmvc.dto.ApiResponse;
import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.repository.CompnyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompnyServic {
    @Autowired
    CompnyRepository compnyRepository;

    public ApiResponse add(Company company){
        Company save=compnyRepository.save(company);
        return new ApiResponse("Saved",true,save);
    }

    public ApiResponse update(Integer id, Company company){
        Company byId = compnyRepository.getById(id);
        byId.setId(id);
        byId.setName(company.getName());
        Company save = compnyRepository.save(byId);
        return new ApiResponse("saved",true,save);

    }

}
