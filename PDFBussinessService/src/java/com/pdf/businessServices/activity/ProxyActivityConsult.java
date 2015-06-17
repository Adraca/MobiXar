package com.pdf.businessServices.activity;

import com.pdf.entity.ActivityEntity;
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
}