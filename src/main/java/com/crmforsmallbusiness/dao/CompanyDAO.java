package com.crmforsmallbusiness.dao;

import com.crmforsmallbusiness.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Андрей on 28.03.2017.
 */
public class CompanyDAO extends BaseDAO<Long, Company> {

    public Company findById(long id) {
        return getByKey(id);
    }

    public Company save(Company contact) {
        return persist(contact);
    }

    public List<Company> findAll() {
        CriteriaBuilder builder = getCriteriaBuilder();
        EntityManager em = getEntityManager();
        CriteriaQuery<Company> criteriaQuery = builder.createQuery(Company.class);
        criteriaQuery.select(criteriaQuery.from(Company.class));
        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<Company> orderedList(String name) throws IllegalArgumentException {
        CriteriaBuilder builder = getCriteriaBuilder();
        EntityManager em = getEntityManager();
        CriteriaQuery<Company> criteriaQuery = builder.createQuery(Company.class);
        Root<Company> companyRoot = criteriaQuery.from(Company.class);
        criteriaQuery.select(companyRoot).orderBy(builder.asc(companyRoot.get(name)));
        return em.createQuery(criteriaQuery).getResultList();
    }

    public boolean delete(long id) {
        Company Company = findById(id);
        if (Company != null) {
            delete(Company);
            return true;
        }
        return false;
    }
}
