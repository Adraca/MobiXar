/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdf.serviceProvider;

import com.pdf.dataManager.facade.ActivityEntityFacade;
import com.pdf.entity.ActivityEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/activity")
public class Activity implements IActivity{
    
    @EJB
    private ActivityEntityFacade activityfacade;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{date}")
    public List<ActivityEntity> activities(@PathParam("date") String date){
        List<ActivityEntity> activityList = activityfacade.findAll();
        return  activityList;
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