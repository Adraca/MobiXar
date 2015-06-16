package com.pdf.dataManager.manager;

import com.pdf.dataManager.facade.ActivityEntityFacade;
import com.pdf.entity.ActivityEntity;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ApplicationScoped
@Getter
@Setter
public class ActivityManager implements Serializable {
    private List<ActivityEntity> activityList;
    
    private Integer id;
    private String name;
    private Integer duration;
    private Date creationDate;
    private Integer cast;
    private String story;
    
    @EJB
    private ActivityEntityFacade activityfacade;
    
    public ActivityManager(){
        activityList = new ArrayList<>();
    }
    
    @PostConstruct
    public void initMethod(){
        activityList =  activityfacade.findAll();
    }
    
    public int getListSize(){
        return this.activityList.size();
    }
}