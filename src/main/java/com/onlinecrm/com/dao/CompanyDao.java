package com.onlinecrm.com.dao;

import com.onlinecrm.com.model.Company;

import java.util.List;

public interface CompanyDao {

	void saveCompany(Company company);
	
	List<Company> findAllCompanies();
	
	void deleteCompanyByName(String name);
	
	Company findByName(String name);

	void updateCompany(Company company);
}
