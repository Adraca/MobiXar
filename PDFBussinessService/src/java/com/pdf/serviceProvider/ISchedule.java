package com.pdf.serviceProvider;

import com.pdf.entity.ScheduleEntity;
import java.util.List;
import javax.ws.rs.PathParam;

public interface ISchedule {
    public List<ScheduleEntity> scheduleList(@PathParam("activityId") String activityId);
    public List<ScheduleEntity> allSchedules();
}
