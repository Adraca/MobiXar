package com.pdf.businessProcess.ratingProc;

import com.pdf.businessServices.rating.ProxyRatingConsult;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class RatingConsult implements IProcessRating{
    @EJB
    private ProxyRatingConsult proxyConsult;
    
    @Override
    public String activityRating(int idActivity) {
        return proxyConsult.activityRating(idActivity);
    }
    
    public RatingConsult(){
    }
}