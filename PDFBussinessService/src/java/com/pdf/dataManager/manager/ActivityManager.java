package com.pdf.dataManager.manager;

import com.pdf.dataManager.IActivity;
import com.pdf.dataManager.facade.ActivityEntityFacade;
import com.pdf.entity.ActivityEntity;
import com.pdf.entity.RatingEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ActivityManager implements IActivity {
    
    @EJB
    private ActivityEntityFacade activityfacade;
    
    public ActivityManager(){
    }
    
    @Override
    public List<ActivityEntity> selectAll(){
        return  activityfacade.findActivity();
    }
    
    public String getRate(String activityName){
        return activityfacade.findRating(activityName);
    }
}