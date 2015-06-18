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
    public String getRate(int idActivity) {
        return proxyConsult.getRate(idActivity);
    }
    
    @Override
    public void rateActivity(int idActivity, double mark){
        proxyConsult.rateActivity(idActivity, mark);
    }
    
    public RatingConsult(){
    }
}