package com.crmforsmallbusiness.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Андрей on 28.03.2017.
 */
public abstract class BaseDAO<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public BaseDAO(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    public T persist(T entity) {
        return (T)getSession().merge(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected CriteriaBuilder getCriteriaBuilder(){
        return getSession().getEntityManagerFactory().getCriteriaBuilder();
    }

    protected EntityManager getEntityManager() {
        return getSession().getEntityManagerFactory().createEntityManager();
    }

}
