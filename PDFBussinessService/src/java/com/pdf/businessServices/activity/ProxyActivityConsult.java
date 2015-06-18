package com.pdf.businessServices.activity;

import com.pdf.entity.ActivityEntity;
import com.pdf.entity.RatingEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@LocalBean
@Stateless
public class ProxyActivityConsult implements IActivable{
    
    @EJB
    private ServActivityConsult activityConsult;

    @Override
    public List<ActivityEntity> activityList(){
         return activityConsult.activityList();
    }
    
    public String activityRating(int idActivity){
        return activityConsult.activityRating(idActivity);
    }
}