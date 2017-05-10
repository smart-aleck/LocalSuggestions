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
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
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

    public T find(PK key) throws NotFoundException {
        T entity = sessionFactory.getCurrentSession().find(persistentClass, key);
        if(entity == null)
            throw new NotFoundException(String.format("[%s] object with id %d not found", persistentClass.toString(), key));

        return entity;
    }

    public Set<T> find(Set<PK> ids) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);
        criteria.where(root.get("id").in(ids));

        return new HashSet<>(
                sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    protected Set<T> findByFieldEquals(String fieldName, Object fieldId) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);
        criteria.where(builder.equal(root.get(fieldName), fieldId));
        return new HashSet<>(
                sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    protected Set<T> findByQuery(String queryStr, Map<String, Object> namedParameters) {
        Query query = sessionFactory.getCurrentSession().createNativeQuery(queryStr, persistentClass);
        namedParameters.entrySet().forEach(entry -> query.setParameter(entry.getKey(), entry.getValue()));
        return new HashSet<>(query.getResultList());
    }
}
