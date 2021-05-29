package edu.depaul.cdm.se452.group2.campusdisconnect.courseComment;

import java.util.*;
import lombok.*;
import java.io.Serializable;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class CourseComment implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentid; 

    private String review;

}