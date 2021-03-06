package com.pdf.businessServices.rating;

import com.pdf.dataManager.manager.RatingManager;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ServRatingConsult implements IRatable{

    @EJB
    private RatingManager ratingManager;
    
    @Override
    public String getRate(int idActivity) {
        return ratingManager.getRate(idActivity);
    }
    
    public ServRatingConsult(){
    }
    
    @Override
    public void rateActivity(int idActivity, double mark){
        ratingManager.rateActivity(idActivity, mark);
    }
}