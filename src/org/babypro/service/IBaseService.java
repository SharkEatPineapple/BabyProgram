package org.babypro.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by johnzhu on 10/27/2016.
 */
public interface IBaseService<T> {

    void save(T t);



    void update(T t);



    void delete(Serializable id);



    T get(Serializable id);



    List<T> getAll();

    <T> T get(CharSequence queryString, Map<String, Object> params);
}
