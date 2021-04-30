package edu.depaul.cdm.se452.group2.campusdisconnect.Courses;
import edu.depaul.cdm.se452.group2.campusdisconnect.CourseComment.*;
import java.util.*;
import lombok.*;
import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;


@Data
@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @Column(name = "courseid") // for the course with quarter/year
    private long courseid;

    @Column(name = "majorid") // for the major 
    private int majorid;

    @Column(name = "pid") // for the proffesor 
    private Long pid;

    @Column(name = "courseName")
    private String courseName;
    
    @Column(name = "StartTime") // time of class
    private String StartTime;

    @Column(name = "EndTime") // time of class
    private String EndTime;

    @Column(name = "credits") // how many credits the class is worth 
    private int credits;

    @Column(name = "deptId")    // for deptarment, is it needed though?
    private int deptId;

    @Column(name = "year")
    private int year;

    @Column(name = "quarter")
    private String quarter;
   
    @OneToMany( orphanRemoval = true,cascade = {CascadeType.ALL} )
    private List<courseComment> comments = new ArrayList<>();

}