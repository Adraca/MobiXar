package com.pdf.dataManager.facade;

import com.pdf.entity.ActivityEntity;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}