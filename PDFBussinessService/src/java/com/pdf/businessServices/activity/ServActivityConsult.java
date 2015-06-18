package com.pdf.businessServices.activity;

import com.pdf.dataManager.manager.ActivityManager;
import com.pdf.entity.ActivityEntity;
import com.pdf.entity.RatingEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@LocalBean
@Stateless
 public class ServActivityConsult implements IActivable{

     @EJB
     private ActivityManager activityManager;
     
    @Override
    public List<ActivityEntity> activityList() {
        return activityManager.selectAll();
    }
    
    public String activityRating(String activityName){
        return activityManager.getRate(activityName);
    }
    
    public ServActivityConsult(){
    }
}