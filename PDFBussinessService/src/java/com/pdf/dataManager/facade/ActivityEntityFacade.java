package com.pdf.dataManager.facade;

import com.pdf.entity.ActivityEntity;
import com.pdf.entity.RatingEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class ActivityEntityFacade extends AbstractFacade<ActivityEntity> {
    @PersistenceContext(unitName = "persistance")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivityEntityFacade() {
        super(ActivityEntity.class);
    }
    
    public List<ActivityEntity> findActivity(){

        Query q = em.createQuery("SELECT e FROM ActivityEntity e where e.id = :pid").setParameter("pid", 1);
        return q.getResultList();
    }
    
    public String findRating(String activityName){
        Query q = em.createQuery("SELECT AVG(r.RATINGMARK) FROM ActivityEntity a, Rating r WHERE a.name = :activityName").
                  setParameter("activityName", activityName);
        return (String)q.getSingleResult();
    }
}