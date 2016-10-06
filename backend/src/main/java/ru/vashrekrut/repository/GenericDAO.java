package ru.vashrekrut.repository;

import ru.vashrekrut.domain.DomainObject;
import ru.vashrekrut.domain.user.Account;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/4/16.
 */
public interface GenericDAO<T extends DomainObject, PK extends Serializable> {
    T read(PK id, boolean lock);
    T querySingle(String query, Map<String, Object> params);
    List<T> queryList(String query);
    void delete(T persistentObject);
    List<T> findAll();
    void save(T entity);
}
