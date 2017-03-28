package com.crmforsmallbusiness.dao;

import com.crmforsmallbusiness.model.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Андрей on 28.03.2017.
 */
public class UserDAO extends BaseDAO<Long, User> {

    public User findById(long id) {
        return getByKey(id);
    }

    public User save(User contact) {
        return persist(contact);
    }

    public List<User> findAll() {
        CriteriaBuilder builder = getCriteriaBuilder();
        EntityManager em = getEntityManager();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        criteriaQuery.select(criteriaQuery.from(User.class));
        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<User> orderedList(String name) throws IllegalArgumentException {
        CriteriaBuilder builder = getCriteriaBuilder();
        EntityManager em = getEntityManager();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.select(userRoot).orderBy(builder.asc(userRoot.get(name)));
        return em.createQuery(criteriaQuery).getResultList();
    }

    public boolean delete(long id) {
        User user = findById(id);
        if (user != null) {
            delete(user);
            return true;
        }
        return false;
    }
}
