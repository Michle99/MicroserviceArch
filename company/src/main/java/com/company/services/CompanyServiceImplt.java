package com.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.entities.Company;
import com.company.repository.CompanyRepository;

@Service
public class CompanyServiceImplt implements CompanyService{

	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Company save(Company company) throws Exception {
		Company companySaved = companyRepository.save(company);
		return companySaved;
	}

	@Override
	public List<Company> getAllCompany() {
		return  companyRepository.findAll();
	}

	@Override
	public void updateCompany(Company company, Long id) {
		company.setCompanyId(id);
		companyRepository.save(company);
	}

	@Override
	public void deleteCompany(Integer id) {
		companyRepository.deleteById(id);;
	}

}
