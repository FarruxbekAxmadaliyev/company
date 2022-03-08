package com.example.springbootmvc.controller;

import com.example.springbootmvc.dto.DepartmentDTO;

import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.entity.Department;
import com.example.springbootmvc.repository.CompnyRepository;

import com.example.springbootmvc.repository.DepartmentReposity;

import com.example.springbootmvc.servis.DepartmentServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/department")
public class DeparmentController {

    @Autowired
    DepartmentServis departmentService;
    @Autowired
    DepartmentReposity departmentRepository;
    @Autowired
    CompnyRepository companyRepository;

    //zaproslarni tutib ishlatish
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getDepartmentPage(Model model) {

        model.addAttribute("list", departmentRepository.findAll());
        //listini yuborish
        return "department/department";
    }

    @GetMapping("/add")
//    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getSavedepartment(Model model) {

        model.addAttribute("companyList", companyRepository.findAll());

        return "department/department-add";
    }

    @PostMapping("/add")
    public String saveDepartment(Model model, @ModelAttribute DepartmentDTO dto) {
        departmentService.add(dto);
        return "redirect:/department";
    }

    @GetMapping("/edit/{id}")
    public  String editDepartment(Model model, @PathVariable Integer id){
//        Department department=new Department();
//        Company company=companyRepository.getById(id);
//        department.setId(id);
//        department.setName(departmentRepository.getById(id).getName());
//        department.setCompany(company);


        model.addAttribute("department",departmentRepository.getById(id));
        model.addAttribute("companyList",companyRepository.findAll());
        return "department/department-edit";
    }
    @PostMapping("/edit/{id}")
    public String editDepartment(@PathVariable Integer id, @ModelAttribute DepartmentDTO department){
        departmentService.update(id,department);
        return "redirect:/department";
    }


    @GetMapping("/delete/{id}") //1 45 24 90
    public String delete(@PathVariable Integer id) {
        departmentRepository.deleteById(id);
        return "redirect:/department";
    }
}
