package org.babypro.dao.org.babypro.dao.impl;

import org.babypro.dao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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


    @Override
    public <T> T get(CharSequence queryString, Map<String, Object> params) {
        Query query = getSession().createQuery(queryString.toString());
        setParameter(query,params);
        List list = query.setMaxResults(1).list();
        if (list.isEmpty()){
            return null;
        }
        return (T) list.get(0);

    }

    protected Query setParameter(Query pQuery, Map<String, Object> pParams) {
        for (Iterator iterator = pParams.keySet().iterator(); iterator.hasNext();){
            String key = (String) iterator.next();
            pQuery.setParameter(key,pParams.get(key));
        }
        return pQuery;
    }
}
