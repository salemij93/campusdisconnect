package edu.depaul.cdm.se452.group2.campusdisconnect.Courses;

import java.util.*;
import lombok.*;
import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;

import edu.depaul.cdm.se452.group2.campusdisconnect.Majors.Major;
import edu.depaul.cdm.se452.group2.campusdisconnect.Professors.Professor;


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
   


}