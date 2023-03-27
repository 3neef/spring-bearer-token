package com.spring.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jwt.model.Company;
import com.spring.jwt.repos.CompanyRepository;
import com.spring.jwt.requests.CreateCompanyRequest;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    public Company create(CreateCompanyRequest createCompanyRequest) {

        Company company = new Company(0, createCompanyRequest.getName());
        // remember sorted in collection is important remember that
        Company result = companyRepository.save(company);
        return result;
    }

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }
}
