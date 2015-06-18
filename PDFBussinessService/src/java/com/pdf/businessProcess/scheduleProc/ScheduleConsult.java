package com.pdf.businessProcess.scheduleProc;

import com.pdf.businessServices.schedule.ProxyScheduleConsult;
import com.pdf.entity.ScheduleEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ScheduleConsult {
    @EJB
    private ProxyScheduleConsult proxySchedule;
    
    public List<ScheduleEntity> selectSchedule(Integer id){
        return proxySchedule.selectSchedule(id);
    }
}