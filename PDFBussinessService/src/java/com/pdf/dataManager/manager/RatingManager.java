package com.pdf.dataManager.manager;

import com.pdf.dataManager.IRating;
import com.pdf.dataManager.facade.RatingEntityFacade;
import com.pdf.entity.RatingEntity;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RatingManager implements IRating {
    @EJB
    private RatingEntityFacade ratingfacade;
    
    public RatingManager(){
    }
    
    public String getRate(int idActivity){
        return ratingfacade.findRating(idActivity);
    }

    @Override
    public void rateActivity(int idActivity, double mark) {
        RatingEntity rate = new RatingEntity();
        rate.setIdActivity(idActivity);
        rate.setMark(mark);
        ratingfacade.create(rate);
    }
}