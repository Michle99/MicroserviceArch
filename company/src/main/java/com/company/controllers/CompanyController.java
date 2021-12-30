package com.company.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.company.entities.Company;
import com.company.services.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	


	@PostMapping("/company")
	@ResponseStatus(code = HttpStatus.CREATED)
	Company createCompany( @RequestBody Company company) throws Exception {
		Company companyPosted = companyService.save(company);
		return companyPosted;
	}
	
	@GetMapping("/company")
	List<Company> findAllCompany(){
		return companyService.getAllCompany();
	}
	
	@PutMapping("/company/{id}")
	String updateUser (@RequestBody Company company, @PathVariable Long id) throws Exception {
		companyService.updateCompany(company, id);
		return company.getCompanyName();
	}
	
	@DeleteMapping("/company/{id}")
	void deleteUser(@PathVariable Integer id) {
		companyService.deleteCompany(id);
	}



	
}
