package com.pdf.businessProcess.activityProc;


import com.pdf.businessServices.activity.IActivable;
import com.pdf.businessServices.activity.ProxyActivityConsult;
import com.pdf.businessServices.activity.ServActivityConsult;
import com.pdf.dataManager.facade.ActivityEntityFacade;
import com.pdf.entity.ActivityEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;



@LocalBean
@Stateless
public class ActivityConsult implements IProcessActivitable {
 
    @EJB
    private ProxyActivityConsult proxyActivityConsult;
   
    
    @Override
    public List<ActivityEntity> listingActivities() {
        return proxyActivityConsult.activityList();
        //IActivable businessActivity = new ProxyActivityConsult();
        //return businessActivity.activityList();
    }
}