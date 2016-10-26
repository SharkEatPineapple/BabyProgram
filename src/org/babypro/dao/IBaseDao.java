package org.babypro.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by johnzhu on 10/27/2016.
 */
public interface IBaseDao<T> {

    void save(T t);

    void update(T t);

    void delete(Class<T> entityClass, Serializable id);

    T get(Class<T> entityClass, Serializable id);

    List<T> getAll(Class<T> entityClass);


}
