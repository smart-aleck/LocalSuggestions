package com.fabs.dao.users;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;

//http://websystique.com/springmvc/spring-mvc-4-fileupload-download-hibernate-example/
@Transactional(value = "transactionManagerUsers", rollbackFor = Exception.class)
public abstract class AbstractUsersDAO<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactoryUsers")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public AbstractUsersDAO(){
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

    public T find(PK id) throws NotFoundException {
        T entity = sessionFactory.getCurrentSession().find(persistentClass, id);
        if(entity == null)
            throw new NotFoundException(String.format("[%s] object with id %d not found", persistentClass.toString(), id));

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
}
