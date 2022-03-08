package com.example.springbootmvc.controller;

import com.example.springbootmvc.dto.EmployeeDTO;
import com.example.springbootmvc.repository.DepartmentReposity;
import com.example.springbootmvc.repository.EmployeeReposity;
import com.example.springbootmvc.servis.EmployeServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping ("/employee")
public class EmployeeController {
    @Autowired
    EmployeeReposity employeeReposity;
    @Autowired
    EmployeServic employeeServis;
    @Autowired
    DepartmentReposity departmentReposity;
    @GetMapping
    public String getEmployee(Model model){
        model.addAttribute("list",employeeReposity.findAll());
        return "employee/employee";
    }


    @GetMapping("/add")
    public String getSaveemployee(Model model){
        model.addAttribute("departmentList",departmentReposity.findAll());
        return "employee/employee-add";
    }



    @PostMapping("/add")
    public String saveEmployee(Model model, @ModelAttribute EmployeeDTO employeeDTO){
        employeeServis.add(employeeDTO);
        return "redirect:/employee";
    }




    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        employeeReposity.deleteById(id);
        return "redirect:/employee";
    }



    @GetMapping(path = "/edit/{id}")
    public String edit(Model model ,@PathVariable Integer id){
        model.addAttribute("employee",employeeReposity.getById(id));
        model.addAttribute("departmentList",departmentReposity.findAll());
        return "employee/employee-edit";
    }





    @PostMapping(path = "/edit/{id}")
    public String update(@ModelAttribute EmployeeDTO employeeDTO, @PathVariable Integer id){
        employeeServis.update(id,employeeDTO);
        return "redirect:/employee";
    }

}
