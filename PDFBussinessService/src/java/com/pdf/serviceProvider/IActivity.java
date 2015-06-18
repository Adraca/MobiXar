package com.pdf.serviceProvider;

import com.pdf.entity.ActivityEntity;
import java.util.List;
import javax.ws.rs.PathParam;

public interface IActivity {
    
    public List<ActivityEntity> activities();
    //public String activityRating(@PathParam("idActivity") String idActivity);
    public void evaluateActivity(@PathParam("name") String name,
                                 @PathParam("note") int note);
}