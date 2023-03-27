package com.spring.jwt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jwt.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{
    
}
