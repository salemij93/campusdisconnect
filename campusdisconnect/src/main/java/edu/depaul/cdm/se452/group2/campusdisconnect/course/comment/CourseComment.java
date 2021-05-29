package edu.depaul.cdm.se452.group2.campusdisconnect.course.comment;

import lombok.*;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Id;

@Data
@Entity
public class CourseComment implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentid; 
    private Date date;
    private String review;

}