package com.pdf.dataManager;

import com.pdf.entity.ActivityEntity;
import com.pdf.entity.RatingEntity;
import java.util.List;

public interface IActivity {
    public List<ActivityEntity> selectAll();
    public String getRate(String activityName);
}
