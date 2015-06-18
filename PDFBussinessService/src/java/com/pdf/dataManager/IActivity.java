package com.pdf.dataManager;

import com.pdf.entity.ActivityEntity;
import java.util.List;

public interface IActivity {
    public List<ActivityEntity> selectAll();
    public String getRate(int idActivity);
}