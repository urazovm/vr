package ru.vashrekrut.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vashrekrut.domain.DomainObject;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/23/16.
 */
@Repository
@SuppressWarnings("unchecked")
public abstract class GenericDAOImpl<T extends DomainObject, PK extends Serializable>
        implements GenericDAO<T, PK> {
    private Class<T> persistentClass;

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }


    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void save(T entity) {
        if (entity.getId() == null) {
            create(entity);
        } else {
            update(entity);
        }
    }

    @Transactional
    @SuppressWarnings("unchecked")
    private void create(T newInstance) {
        em.persist(newInstance);
    }

    @Transactional
    private void update(T trancientObject) {
        em.merge(trancientObject);
    }

    @Transactional
    public void delete(T persistentObject) {
        em.remove(em.contains(persistentObject) ? persistentObject : em.merge(persistentObject));
    }

    public void flush() {
        em.flush();
    }

    public void clear() {
        em.clear();
    }

    public T read(PK id, boolean lock) {
        T entity;
        if (lock) {
            entity = em.find(getPersistentClass(), id, LockModeType.OPTIMISTIC);
        } else {
            entity = em.find(getPersistentClass(), id);
        }

        return entity;
    }

    public T querySingle(String namedQuery, Map<String, Object> parameters) {
        return (T) query(namedQuery, parameters).getSingleResult();
    }

    public List<T> queryList(String namedQuery) {
        return query(namedQuery, null).getResultList();
    }

    protected List<T> queryList(String namedQuery, Map<String, Object> parameters) {
        return query(namedQuery, parameters).getResultList();
    }

    private Query query(String namedQuery, Map<String, Object> parameters) {
        Query query = em.createNamedQuery(namedQuery);
        if (parameters != null && !parameters.isEmpty())
        {
            for (Map.Entry<String, Object> entry: parameters.entrySet())
            {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        return query;
    }

    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(getPersistentClass()));
        return em.createQuery(cq).getResultList();
    }
}
