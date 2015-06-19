package com.pdf.businessServices.schedule;

import com.pdf.entity.ScheduleEntity;
import java.util.List;

public interface ISchedulable {
    public List<ScheduleEntity> selectSchedule(Integer id);
    public List<ScheduleEntity> allSchedules();
}