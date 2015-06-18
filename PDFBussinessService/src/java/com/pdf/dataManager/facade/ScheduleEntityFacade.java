package com.pdf.dataManager.facade;

import com.pdf.entity.ScheduleEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@LocalBean
@Stateless
public class ScheduleEntityFacade extends AbstractFacade<ScheduleEntity> {
    @PersistenceContext(unitName = "persistance")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ScheduleEntityFacade() {
        super(ScheduleEntity.class);
    }
    
    public List<ScheduleEntity> findSchedule(Integer id){
        Query q = em.createQuery("SELECT s FROM ScheduleEntity s where s.idActivity = :pid").setParameter("pid", id);
        return q.getResultList();
    }
}