package com.onlinecrm.com.dao.daoImpl;

import com.onlinecrm.com.dao.AbstractDao;
import com.onlinecrm.com.dao.CompanyDao;
import com.onlinecrm.com.model.Company;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

//@Repository("companyDao")
public class CompanyDaoImpl extends AbstractDao implements CompanyDao {

	public void saveCompany(Company company) {
		persist(company);
	}

	@SuppressWarnings("unchecked")
	public List<Company> findAllCompanies() {
		Criteria criteria = getSession().createCriteria(Company.class);
		return (List<Company>) criteria.list();
	}

	public void deleteCompanyByName(String name) {
		Query query = getSession().createSQLQuery("delete from company where name = :name");
		query.setString("name", name);
		query.executeUpdate();
	}

	
	public Company findByName(String name){
		Criteria criteria = getSession().createCriteria(Company.class);
		criteria.add(Restrictions.eq("name", name));
		return (Company) criteria.uniqueResult();
	}
	
	public void updateCompany(Company company){
		getSession().update(company);
	}
	
}
