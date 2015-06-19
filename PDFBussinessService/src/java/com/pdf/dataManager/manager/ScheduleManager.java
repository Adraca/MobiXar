package com.pdf.dataManager.manager;

import com.pdf.dataManager.ISchedule;
import com.pdf.dataManager.facade.ScheduleEntityFacade;
import com.pdf.entity.ScheduleEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ScheduleManager implements ISchedule{
    @EJB
    private ScheduleEntityFacade schedulefacade;
    
    public ScheduleManager(){
    }
    
    public List<ScheduleEntity> selectSchedule(Integer id){
        return schedulefacade.findSchedule(id);
    }
    
    public List<ScheduleEntity> allSchedules(){
        return schedulefacade.findAll();
    }
}