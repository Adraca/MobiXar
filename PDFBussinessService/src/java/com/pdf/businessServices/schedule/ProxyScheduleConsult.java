package com.pdf.businessServices.schedule;

import com.pdf.entity.ScheduleEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ProxyScheduleConsult {
    @EJB
    private ServScheduleConsult servSchedule;
    
    public List<ScheduleEntity> selectSchedule(Integer id){
        return servSchedule.selectSchedule(id);
    }
    
    public List<ScheduleEntity> allSchedules(){
        return servSchedule.allSchedules();
    }
}