package com.pdf.dataManager.facade;

import com.pdf.entity.RatingEntity;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@LocalBean
@Stateless
public class RatingEntityFacade extends AbstractFacade<RatingEntity> {
    @PersistenceContext(unitName = "persistance")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RatingEntityFacade() {
        super(RatingEntity.class);
    }
    
    public String findRating(int idActivity){
        Query q = em.createQuery(
                "SELECT AVG(r.mark) FROM RatingEntity r WHERE r.idActivity = :idactivity").
                  setParameter("idactivity", idActivity);
        return String.valueOf(q.getSingleResult());
    }
}