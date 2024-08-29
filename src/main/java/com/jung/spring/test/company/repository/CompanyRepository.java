package com.jung.spring.test.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jung.spring.test.company.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
