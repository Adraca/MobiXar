package com.pdf.dataManager.facade;

import com.pdf.entity.ActivityEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public List<ActivityEntity> findActivity(Integer id){
        Query q = em.createQuery("SELECT e FROM ActivityEntity e where e.id = :pid").setParameter("pid", id);
        return q.getResultList();
    }
    
    public String findRating(int idActivity){
        Query q = em.createQuery(
                "SELECT AVG(r.mark) FROM ActivityEntity a, RatingEntity r WHERE a.name = :activityName AND ActivityEntity.id = RatingEntity.id").
                  setParameter("activityName", idActivity);
        return (String)q.getSingleResult();
    }
}