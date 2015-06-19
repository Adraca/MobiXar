package com.pdf.serviceProvider;

import com.pdf.businessProcess.scheduleProc.ScheduleConsult;
import com.pdf.entity.ScheduleEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/schedule")
public class Schedule implements ISchedule{
   @EJB
   private ScheduleConsult scheduleConsult;
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/{activityId}")
   public List<ScheduleEntity> scheduleList(@PathParam("activityId") String activityId){
       List<ScheduleEntity> schedule = scheduleConsult.selectSchedule(Integer.valueOf(activityId));
       return schedule;
   }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<ScheduleEntity> allSchedules() {
        List<ScheduleEntity> schedules = scheduleConsult.allSchedules();
        return schedules;
    }
}