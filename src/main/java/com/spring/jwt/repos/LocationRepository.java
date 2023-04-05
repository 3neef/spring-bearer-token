package com.spring.jwt.repos;

import com.spring.jwt.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface LocationRepository extends JpaRepository<Location, Long> {

}
