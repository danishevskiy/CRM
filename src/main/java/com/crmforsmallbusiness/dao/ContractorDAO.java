package com.crmforsmallbusiness.dao;

import com.crmforsmallbusiness.model.Contractor;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Андрей on 28.03.2017.
 */
public class ContractorDAO extends BaseDAO<Long, Contractor> {

    public Contractor findById(long id) {
        return getByKey(id);
    }

    public Contractor save(Contractor contact) {
        return persist(contact);
    }

    public List<Contractor> findAll() {
        CriteriaBuilder builder = getCriteriaBuilder();
        EntityManager em = getEntityManager();
        CriteriaQuery<Contractor> criteriaQuery = builder.createQuery(Contractor.class);
        criteriaQuery.select(criteriaQuery.from(Contractor.class));
        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<Contractor> orderedList(String name) throws IllegalArgumentException {
        CriteriaBuilder builder = getCriteriaBuilder();
        EntityManager em = getEntityManager();
        CriteriaQuery<Contractor> criteriaQuery = builder.createQuery(Contractor.class);
        Root<Contractor> contractorRoot = criteriaQuery.from(Contractor.class);
        criteriaQuery.select(contractorRoot).orderBy(builder.asc(contractorRoot.get(name)));
        return em.createQuery(criteriaQuery).getResultList();
    }

    public boolean delete(long id) {
        Contractor contractor = findById(id);
        if (contractor != null) {
            delete(contractor);
            return true;
        }
        return false;
    }
}
