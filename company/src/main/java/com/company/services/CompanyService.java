package com.company.services;

import java.util.List;

import com.company.entities.Company;



public interface CompanyService {

	Company save(Company company) throws Exception;
	
	List<Company> getAllCompany();

	void updateCompany(Company company, Long id);

	void deleteCompany(Integer id);
}
