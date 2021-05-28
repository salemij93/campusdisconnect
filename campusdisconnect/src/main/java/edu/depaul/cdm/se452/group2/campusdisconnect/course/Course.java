package edu.depaul.cdm.se452.group2.campusdisconnect.course;
import java.util.*;

import edu.depaul.cdm.se452.group2.campusdisconnect.course.comment.CourseComment;
import lombok.*;
import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;

import edu.depaul.cdm.se452.group2.campusdisconnect.major.Major;
import edu.depaul.cdm.se452.group2.campusdisconnect.professor.Professor;


@Data
@Entity
public class Course implements Serializable {

    @Id
    private long courseid;
    private String courseName;
    private String StartTime;
    private String EndTime;
    private int credits;
    private int year;
    private String quarter;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Major.class)
    private Major major;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Professor.class)
    private Professor professor;
   
    @OneToMany(orphanRemoval = true,cascade = {CascadeType.ALL} )
    private List<CourseComment> comments = new ArrayList<>();

}