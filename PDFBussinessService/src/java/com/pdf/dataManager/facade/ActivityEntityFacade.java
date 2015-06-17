package com.pdf.dataManager.facade;

import com.pdf.entity.ActivityEntity;
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
    
    public List<ActivityEntity> findAllNames(){
        //return em.createQuery(
        //"SELECT u FROM Activity").getResultList();
        /*CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<ActivityEntity> c = cq.from(ActivityEntity.class);
        cq.select(c);
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        cq.where(cb.gt(c.get("id"), 1));
        q.setFirstResult(0);
        return q.getResultList();*/
        Query q = em.createQuery("SELECT e FROM ActivityEntity e where e.id = :pid").setParameter("pid", 1);
        return q.getResultList();
    }
    
    //public List<ActivityEntity> findWithRating(){
    //    return em.createQuery(
    //    "SELECT name FROM Activity, Rating WHERE Activity.IdActivity = Rating.IdActivity").getResultList();
    //set parameter avec q.setParameter("id", 2104);
    //}
}