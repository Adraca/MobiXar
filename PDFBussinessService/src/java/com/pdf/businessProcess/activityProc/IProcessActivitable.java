/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdf.businessProcess.activityProc;

import com.pdf.entity.ActivityEntity;
import com.pdf.entity.RatingEntity;
import java.util.List;

/**
 *
 * @author fra
 */
public interface IProcessActivitable {

    public List<ActivityEntity> listingActivities();
    public String activityRating(String activityName);
}