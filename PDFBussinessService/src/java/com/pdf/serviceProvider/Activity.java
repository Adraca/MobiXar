package com.pdf.serviceProvider;

import com.pdf.businessProcess.activityProc.ActivityConsult;
import com.pdf.businessServices.activity.ServActivityConsult;
import com.pdf.dataManager.facade.ActivityEntityFacade;
import com.pdf.entity.ActivityEntity;
import com.pdf.entity.RatingEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/activity")
public class Activity implements IActivity{
        
    @EJB
    private ActivityConsult busActivityConsult;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{date}")
    public List<ActivityEntity> activities(@PathParam("date") String date){
         List<ActivityEntity> activity = busActivityConsult.listingActivities();
         return activity;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{activityName}")
    public String activityRating(@PathParam("activityName") String activityName){
        String rating = busActivityConsult.activityRating(activityName);
        return rating;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}/{date}")
    public String getActivity(@PathParam("name") String name,
                              @PathParam("date") String date){
        
        return null;
    }
    
    @GET
    public void evaluateActivity(@PathParam("name") String name,
                                 @PathParam("note") int note){
    }
}