package com.spring.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jwt.model.Company;
import com.spring.jwt.requests.CreateCompanyRequest;
import com.spring.jwt.response.BasicResponse;
import com.spring.jwt.service.CompanyService;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/company/")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @PostMapping(name = "/")
    public @ResponseBody ResponseEntity<?> insert(@RequestBody @Valid CreateCompanyRequest input) {
        Company company = companyService.create(input);// call function in services
        if (company != null) {
            return new ResponseEntity<>(new BasicResponse("created successfully", "000", company), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new BasicResponse("created fail", "999", null), HttpStatus.OK);
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> getAll() {
        List<Company> company = companyService.getAllCompany();// call function in services
        if (company != null) {
            return new ResponseEntity<>(new BasicResponse(" Successfully", "000", company), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new BasicResponse(" No Data Found ", "999", null), HttpStatus.OK);
        }
    }


}
