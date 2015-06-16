/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdf.serviceProvider;

import com.pdf.entity.ActivityEntity;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 *
 * @author fra
 */
public interface IActivity {
    
    public List<ActivityEntity> activities(@PathParam("date") String date);
    
    public String getActivity(@PathParam("name") String name,
                              @PathParam("date") String date);
    
    public void evaluateActivity(@PathParam("name") String name,
                                 @PathParam("note") int note);
}
