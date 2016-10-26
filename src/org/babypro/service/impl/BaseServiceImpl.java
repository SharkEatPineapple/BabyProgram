package org.babypro.service.impl;

import org.babypro.dao.IBaseDao;
import org.babypro.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by johnzhu on 10/27/2016.
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private IBaseDao mBaseDao;

    private Class<T> mEntityClass;

    public BaseServiceImpl() {
        Class clazz = getClass();
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType){
            ParameterizedType pType = (ParameterizedType) type;
            mEntityClass = (Class<T>) pType.getActualTypeArguments()[0];
        }
    }

    @Override
    @Transactional
    public void save(T pT) {
        mBaseDao.save(pT);
    }

    @Override
    @Transactional
    public void update(T pT) {
        mBaseDao.update(pT);
    }

    @Override
    @Transactional
    public void delete(Serializable pId) {

        mBaseDao.delete(mEntityClass, pId);
    }

    @Override
    public T get(Serializable pId) {
        return (T)mBaseDao.get(mEntityClass, pId);
    }

    @Override
    public List<T> getAll() {
        return mBaseDao.getAll(mEntityClass);
    }
}
