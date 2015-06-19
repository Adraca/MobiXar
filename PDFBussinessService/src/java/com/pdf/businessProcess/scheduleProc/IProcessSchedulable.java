package com.pdf.businessProcess.scheduleProc;

import com.pdf.entity.ScheduleEntity;
import java.util.List;

public interface IProcessSchedulable {
    public List<ScheduleEntity> selectSchedule(Integer id);
    public List<ScheduleEntity> allSchedules();
}