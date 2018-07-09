package com.macbeth.algorithm.dao;

import java.util.Collection;
import java.util.List;

/**
 * author:macbeth
 * Date:2018/7/6
 * Time:14:45
 **/
public interface EntityDao<T> {

    void save(T entity);

    void update(T entity);

    boolean delete(Long id);

    T getById(Long id);

    List<T> getByIds(Collection<Long> collection);
}
