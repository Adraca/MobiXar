package com.pdf.businessServices.activity;

import com.pdf.entity.ActivityEntity;
import com.pdf.entity.RatingEntity;
import java.util.List;

public interface IActivable {
    public List<ActivityEntity> activityList();
    public String activityRating(int idActivity);
}