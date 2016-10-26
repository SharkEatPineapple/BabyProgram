package org.babypro.dao.org.babypro.dao.impl;

import org.babypro.dao.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by johnzhu on 10/27/2016.
 */
@Repository
public class BaseDaoImpl<T> implements IBaseDao<T> {
    @Autowired
    private SessionFactory mSessionFactory;



    private Session getSession() {
        return mSessionFactory.getCurrentSession();
    }



    @Override
    public void save(T pT) {

        getSession().save(pT);
    }



    @Override
    public void update(T pT) {
        getSession().update(pT);
    }


    @Override
    public void delete(Class<T> entityClass, Serializable id) {
        T t = get(entityClass,id);
        if (t!=null){
            getSession().delete(t);
        }

    }


    @Override
    public T get(Class<T> entityClass, Serializable id) {

        return (T)getSession().get(entityClass,id);
    }



    @Override
    public List<T> getAll(Class<T> entityClass) {
        return getSession().createCriteria(entityClass).list();
    }





}
