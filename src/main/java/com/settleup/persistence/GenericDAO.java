package com.settleup.persistence;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.*;


public class GenericDAO<T> {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Class<T> type;
    private Class<T> entity;

    public GenericDAO(Class<T> type) {

        this.type = type;

    }

    public <T>T getById(int id) {

        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();

        return entity;

    }

    /**
     * Delete a entity
     * @param entity User to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }


    public List<T> getAll() {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();

        session.close();
        return list;

    }


    /**
     * update user
     * @param entity  User to be inserted or updated
     */
    public int insert(T entity) {

        logger.debug("type " + entity);

        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * update user
     * @param entity  User to be inserted or updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastName", "Curry")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria search
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entity = session.createQuery(query).getResultList();

        session.close();
        return entity;
    }




    public List<T> getElementsAndClause(String fieldNameOne, int fieldValueOne, String fieldNameTwo, String fieldValueTwo) {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(type);

        Root<T> root = query.from(type);
        Predicate predicate = builder.and(
                builder.equal(root.get(fieldNameOne), fieldValueOne),
                builder.equal(root.get(fieldNameTwo), fieldValueTwo)
        );

        query.where(predicate);
        List<T> element = session.createQuery(query).getResultList();
        session.close();

        return element;

    }

    public List<T> getElementsByRangeAndValues(Integer minValue, Integer maxValue, String searchByPropertyOne, String searchByPropertyTwo, String valueTwo) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);

        Root<T> root = query.from(type);

        Predicate predicateOne = builder.lessThanOrEqualTo(root.get(searchByPropertyOne), maxValue);
        Predicate predicateTwo = builder.greaterThanOrEqualTo(root.get(searchByPropertyOne), minValue);

        Predicate predicateThree = builder.equal(root.get(searchByPropertyTwo), valueTwo);

        Predicate[] predicates = new Predicate[3];

        predicates[0] = predicateOne;
        predicates[1] = predicateTwo;
        predicates[2] = predicateThree;
        query.select(root).where(predicates);
        List<T> elements = session.createQuery(query).getResultList();
        transaction.commit();
        session.close();

        return  elements;

    }


    private Session getSession() {

        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}
