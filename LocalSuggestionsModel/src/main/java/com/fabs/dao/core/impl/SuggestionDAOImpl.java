package com.fabs.dao.core.impl;

import com.fabs.dao.core.SuggestionDAO;
import com.fabs.model.core.Suggestion;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.vividsolutions.jts.geom.Point;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class SuggestionDAOImpl implements SuggestionDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public SuggestionDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Suggestion suggestion) throws MissingDataException {
        try {
            suggestion.setVersion(suggestion.getVersion() + 1);
            suggestion.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(suggestion);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(suggestion, exception);
        }
    }

    public void delete(Suggestion suggestion) throws MissingDataException {
        saveOrUpdate(suggestion);
        suggestion.setDeleted(true);
    }

    public Suggestion find(Long id) throws NotFoundException {
        Suggestion suggestion = sessionFactory.getCurrentSession().find(Suggestion.class, id);
        if(suggestion == null)
            throw new NotFoundException(String.format("[Suggestion] object with id {0} not found", id));

        return suggestion;
    }

    public Set<Suggestion> findByUser(Integer userId) throws NotFoundException {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Suggestion> criteria = builder.createQuery(Suggestion.class);
        Root<Suggestion> root = criteria.from(Suggestion.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("userId"), userId));
        return new HashSet<>(
                sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    public Set<Suggestion> find(Point location, Double radius) {
        return null;
    }
}
