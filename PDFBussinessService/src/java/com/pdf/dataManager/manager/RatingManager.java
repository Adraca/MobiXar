package com.pdf.dataManager.manager;

import com.pdf.dataManager.IRating;
import com.pdf.dataManager.facade.RatingEntityFacade;
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
}