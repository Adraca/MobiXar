package com.pdf.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="schedule")
@Getter
@Setter
public class ScheduleEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="IDSCHEDULE")
    private Integer id;
    
    @Column(name="IDACTIVITY")
    private Integer idActivity;
    
    @Column(name="ACTIVITYTIME")
    private String time;
    
    public ScheduleEntity(){
    }
}