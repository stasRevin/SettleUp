package com.settleup.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.*;

/**
 * Class to serve as database data retriever based on the passed parameters
 * @author oponomarova
 * @author srevin
 * @param <T> The type.
 */
public class GenericDAO<T> {

    private Class<T> type;

    /**
     * Constructor for the the provided type.
     * @param type The class type.
     */
    public GenericDAO(Class<T> type) {

        this.type = type;
    }

    /**
     * Retrieves data based on the id value of the entity
     * @param id The entity id
     * @param <T> The type.
     * @return values based on id
     */
    /*
    public <T>T getById(int id) {

        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;

    }
*/
    /**
     * Get all data from the entity.
     * @return result in the list
     */
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
     * Gets the results based on the range parameters example between 20 and 30 and entities
     * usage (600, 1500, "rent_0", "county", "Cameron County")
     * @param minValue The minimum value.
     * @param maxValue The maximum value.
     * @param searchByPropertyOne The property one search criterion.
     * @param searchByPropertyTwo The property two search criterion.
     * @param valueTwo The second value.
     * @return list of values based on the criteria
     */
    public List<T> getElementsByRangeAndValues(Integer minValue, Integer maxValue, String searchByPropertyOne,
                                               String searchByPropertyTwo, String valueTwo) {

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

    /**
     * Opens the session
     * @return session
     */
    private Session getSession() {

        return SessionFactoryProvider.getSessionFactory().openSession();
    }

}
