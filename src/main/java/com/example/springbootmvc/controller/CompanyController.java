package com.example.springbootmvc.controller;

import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.repository.CompnyRepository;
import com.example.springbootmvc.servis.CompnyServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompnyServic compnyServic;
    @Autowired
    CompnyRepository compnyRepository;




@GetMapping
public String getCompanyPage(Model model){
    model.addAttribute("list",compnyRepository.findAll());
    return "company/company";


}
@GetMapping("/add")
    public String getSavecompany(){
    return "company/company-add";
}


@PostMapping("/add")
    public String saveCompany(Model model,@ModelAttribute Company company){
    compnyServic.add(company);
    return "redirect:/company";
}
@GetMapping("/edit/{id}")
public String edit(Model model,@PathVariable Integer id){
    Company company=new Company();
    company.setId(id);
    company.setName(compnyRepository.findById(id).get().getName());
    model.addAttribute("company",company);
    return "company/company-edit";
}
@PostMapping("/edit/{id}")
    public  String editCompany(@PathVariable Integer id, @ModelAttribute Company company){
    compnyServic.update(id,company);
    return "redirect:/company";
}
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        compnyRepository.deleteById(id);
        return "redirect:/company";
    }

}

