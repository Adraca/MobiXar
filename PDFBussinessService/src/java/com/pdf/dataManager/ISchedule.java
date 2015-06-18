package com.pdf.dataManager;

import com.pdf.entity.ScheduleEntity;
import java.util.List;

public interface ISchedule {
    public List<ScheduleEntity> selectSchedule(Integer id);
}