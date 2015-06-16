package com.pdf.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="activity")
@Getter
@Setter
public class ActivityEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="IDACTIVITY")
    private Integer id;
    
    @Column(name="ACTIVITYNAME")
    private String name;
    
    @Column(name="ACTIVITYDURATION")
    private Integer duration;
    
    @Column(name="ACTIVITYCREATIONDATE")
    private Date creationDate;
   
    @Column(name="ACTIVITYCAST")
    private Integer cast;
    
    @Column(name="ACTIVITYSTORY")
    private String story;
    
    public ActivityEntity(){
    }
}
