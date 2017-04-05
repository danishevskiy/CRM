package com.onlinecrm.com.service.serviceImpl;

import com.onlinecrm.com.dao.CompanyDao;
import com.onlinecrm.com.model.Company;
import com.onlinecrm.com.model.User;
import com.onlinecrm.com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao dao;
	
	public void saveCompany(Company company) {
		dao.saveCompany(company);
	}

	public List<Company> findAllCompanies() {
		return dao.findAllCompanies();
	}

	public void deleteCompanyByName(String name) {
		dao.deleteCompanyByName(name);
	}

	public Company findByName(String name) {
		return dao.findByName(name);
	}

	public void updateCompany(Company company){
		dao.updateCompany(company);
	}
}
