package com.onlinecrm.com.service;

import com.onlinecrm.com.model.Company;

import java.util.List;

public interface CompanyService {

	void saveCompany(Company company);

	List<Company> findAllCompanies();

	void deleteCompanyByName(String name);

	Company findByName(String name);

	void updateCompany(Company company);
}
