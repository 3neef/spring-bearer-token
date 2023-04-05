package com.spring.jwt.repos;

import com.spring.jwt.model.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long> {

}
