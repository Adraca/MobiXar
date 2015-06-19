package com.pdf.businessServices.schedule;

import com.pdf.dataManager.manager.ScheduleManager;
import com.pdf.entity.ScheduleEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ServScheduleConsult implements ISchedulable {
    @EJB
    private ScheduleManager scheduleManager;
    
    public List<ScheduleEntity> selectSchedule(Integer id){
        return scheduleManager.selectSchedule(id);
    }
    
    public List<ScheduleEntity> allSchedules(){
        return scheduleManager.allSchedules();
    }
}