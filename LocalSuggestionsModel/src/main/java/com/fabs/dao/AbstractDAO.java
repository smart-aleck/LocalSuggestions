package com.fabs.dao;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//http://websystique.com/springmvc/spring-mvc-4-fileupload-download-hibernate-example/
public abstract class AbstractDAO<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDAO(){
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected T refreshEntity(T entity){
        sessionFactory.getCurrentSession().refresh(entity);
        return entity;
    }

    protected void saveOrUpdateEntity(T entity) throws MissingDataException {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(entity);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(entity, exception);
        }
    }

    protected void saveOrUpdateEntity(Set<T> entities) throws MissingDataException {
        try {
            entities.forEach(entity -> sessionFactory.getCurrentSession().saveOrUpdate(entity));
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(entities, exception);
        }
    }

    protected T findEntity(PK key) throws NotFoundException {
        T entity = null;
        try {
            entity = sessionFactory.getCurrentSession().find(persistentClass, key);
        }
        catch (IllegalArgumentException exception){
            throw new NotFoundException(String.format("[%s] object with id %s is invalid",
                    persistentClass.toString(), key), exception);
        }
        if(entity == null)
            throw new NotFoundException(String.format("[%s] object with id %s not found", persistentClass.toString(), key));

        return entity;
    }

    protected Set<T> findEntity(Set<PK> ids) {
        if(ids.size() == 0)
            return new HashSet<T>();

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(persistentClass);
        Root<T> root = criteriaQuery.from(persistentClass);
        criteriaQuery.select(root);
        criteriaQuery.where(root.get("id").in(ids));

        return new HashSet<>(
                sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList());
    }

    protected Set<T> findByFieldEquals(String fieldName, Object fieldId) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(persistentClass);

        Root<T> root = criteriaQuery.from(persistentClass);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get(fieldName), fieldId));
        return new HashSet<>(
                sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList());
    }

    protected Set<T> findByQuery(String queryStr, Map<String, Object> namedParameters) {
        Query query = sessionFactory.getCurrentSession().createNativeQuery(queryStr, persistentClass);
        namedParameters.entrySet().forEach(entry -> query.setParameter(entry.getKey(), entry.getValue()));
        return new HashSet<T>(query.getResultList());
    }

    //http://stackoverflow.com/questions/2883887/in-jpa-2-using-a-criteriaquery-how-to-count-results
    protected Long rowCount(){
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        criteriaQuery.select(builder.count(criteriaQuery.from(persistentClass)));
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
    }
//    protected Long rowCount(String fieldName, Object fieldId){
//        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
//
//        Root<T> root = criteriaQuery.from(persistentClass);
//        criteriaQuery.select(builder.count(root));
//        criteriaQuery.where(builder.equal(root.get(fieldName), fieldId));
//        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
//    }
}
