package edu.depaul.cdm.se452.group2.campusdisconnect.courses;
import edu.depaul.cdm.se452.group2.campusdisconnect.courseComment.*;
import java.util.*;
import lombok.*;
import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;

import edu.depaul.cdm.se452.group2.campusdisconnect.majors.Major;
import edu.depaul.cdm.se452.group2.campusdisconnect.professors.Professor;


@Data
@Entity

public class Course implements Serializable {

    @Id
    // for the course with quarter/year
    private long courseid;

   
    private String courseName;
    
     // time of class
    private String StartTime;

   // time of class
    private String EndTime;

    // how many credits the class is worth 
    private int credits;

 
    private int year;

    
    private String quarter;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Major.class)
    private Major major;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Professor.class)
    private Professor professor;
   
    @OneToMany( orphanRemoval = true,cascade = {CascadeType.ALL} )
    private List<CourseComment> comments = new ArrayList<>();

}