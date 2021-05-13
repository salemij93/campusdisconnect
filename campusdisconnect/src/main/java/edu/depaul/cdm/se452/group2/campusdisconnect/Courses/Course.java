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
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @Column(name = "courseid") // for the course with quarter/year
    private long courseid;

    @Column(name = "courseName")
    private String courseName;
    
    @Column(name = "StartTime") // time of class
    private String StartTime;

    @Column(name = "EndTime") // time of class
    private String EndTime;

    @Column(name = "credits") // how many credits the class is worth 
    private int credits;

    @Column(name = "year")
    private int year;

    @Column(name = "quarter")
    private String quarter;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Major.class)
    private Major major;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Professor.class)
    private Professor professor;
   
    @OneToMany( orphanRemoval = true,cascade = {CascadeType.ALL} )
    private List<courseComment> comments = new ArrayList<>();

}